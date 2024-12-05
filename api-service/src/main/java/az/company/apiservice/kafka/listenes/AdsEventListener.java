package az.company.apiservice.kafka.listenes;

import az.company.apiservice.kafka.event.AdsEvent;
import az.company.apiservice.service.ad.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdsEventListener {

    public static final String TOPIC_ADS = "ads-events";

    private final AdService adService;

    @KafkaListener(topics = TOPIC_ADS, groupId = "ads-consumer")
    public void adsEventListener(AdsEvent adsEvent) {
        adService.save(adsEvent);
    }

}
