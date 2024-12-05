package az.company.scraperservice.service.scraper;

import az.company.scraperservice.response.base.GetPhonesByItemResponse;
import az.company.scraperservice.service.rest.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

import static az.company.scraperservice.constants.Constants.BASE_URL;

@Service
@RequiredArgsConstructor
public class PhoneScraper {

    private final RestService restService;

    public GetPhonesByItemResponse scrap(long adId) {
        String endpoint = "items/%d/phones".formatted(adId);
        String URL = "%s/%s".formatted(BASE_URL, endpoint);
        return restService.get(URI.create(URL), GetPhonesByItemResponse.class);
    }

}
