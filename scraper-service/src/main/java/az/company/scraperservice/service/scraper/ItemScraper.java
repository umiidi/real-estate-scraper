package az.company.scraperservice.service.scraper;

import az.company.scraperservice.response.base.GetItemResponse;
import az.company.scraperservice.service.rest.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import static az.company.scraperservice.constants.Constants.BASE_URL;

@Service
@RequiredArgsConstructor
public class ItemScraper {

    private static final String operationName = "GetCurrentItem_4261412";
    private static final String variables = "{\"id\":\"%d\"}";
    private static final String extensions = "{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"31a6d9b0ddaeb9f846c2b98400d36e947f9197c3640025daa480fa093336f0ad\"}}";

    private final RestService restService;

    public GetItemResponse scrap(long adId) {
        String URL = "%s/graphql?%s".formatted(BASE_URL, getParams(adId));
        return restService.get(URI.create(URL), GetItemResponse.class);
    }

    public String getParams(long adId) {
        try {
            return String.format("operationName=%s&variables=%s&extensions=%s",
                    URLEncoder.encode(operationName, "UTF-8"),
                    URLEncoder.encode(String.format(variables, adId), "UTF-8"),
                    URLEncoder.encode(extensions, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            throw new RuntimeException("params not build");
        }
    }

}
