package az.company.scraperservice.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class RestService {

    private final RestTemplate restTemplate;

    public <T> T get(URI uri, Class<T> responseType) {
        try {
            return restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    getHttpEntity(),
                    responseType
            ).getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new RuntimeException("scrap dont success");
        }
    }

    private HttpEntity<String> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(httpHeaders);
    }

}
