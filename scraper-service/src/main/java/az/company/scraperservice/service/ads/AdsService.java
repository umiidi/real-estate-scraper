package az.company.scraperservice.service.ads;

import az.company.scraperservice.entity.AdIds;
import az.company.scraperservice.event.AdsEvent;
import az.company.scraperservice.repository.AdIdsRepository;
import az.company.scraperservice.response.base.GetItemResponse;
import az.company.scraperservice.response.base.GetPhonesByItemResponse;
import az.company.scraperservice.response.base.SearchItemsQueryResponse;

import az.company.scraperservice.response.inner.itemsconnection.Edge;
import az.company.scraperservice.service.producer.KafkaAdsProducer;
import az.company.scraperservice.service.scraper.AllItemsScraper;
import az.company.scraperservice.service.scraper.ItemScraper;
import az.company.scraperservice.service.scraper.PhoneScraper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.company.scraperservice.mapper.AdsEventMapper.ADS_EVENT_MAPPER;

@Service
@RequiredArgsConstructor
public class AdsService {

    private final AllItemsScraper allItemsScraper;
    private final ItemScraper itemScraper;
    private final PhoneScraper phoneScraper;

    private final KafkaAdsProducer producer;

    private final AdIdsRepository repository;

    public void adsScrapAndProduce() {

        String cursor = null;
        SearchItemsQueryResponse response;

        int counter = 0;

        do {
            response = allItemsScraper.scrap(cursor);

            List<Edge> edges = getEdges(response);
            for (Edge edge : edges) {
                if (!repository.existsByAdId(edge.getNode().getId())) {
                    AdsEvent event = buildAdsEvent(
                            itemScraper.scrap(edge.getNode().getId()),
                            phoneScraper.scrap(edge.getNode().getId())
                    );

                    producer.send(event);
                    repository.save(new AdIds(edge.getNode().getId()));
                } else {
                    if (counter++ > 100) {
                        return;
                    }
                }
            }

            try {
                Thread.sleep(10_000);   // To avoid block
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cursor = getEndCursor(response);

        } while (hasNextPage(response));

    }

    private AdsEvent buildAdsEvent(GetItemResponse itemResponse, GetPhonesByItemResponse phoneResponse) {
        return ADS_EVENT_MAPPER.mapToAdsEvent(
                itemResponse.getData().getItem(),
                phoneResponse.getPhones()
        );
    }

    private String getEndCursor(SearchItemsQueryResponse response) {
        return response.getData().getItemsConnection().getPageInfo().getEndCursor();
    }

    private List<Edge> getEdges(SearchItemsQueryResponse response) {
        return response.getData().getItemsConnection().getEdges();
    }

    private boolean hasNextPage(SearchItemsQueryResponse response) {
        return response.getData().getItemsConnection().getPageInfo().isHasNextPage();
    }

}
