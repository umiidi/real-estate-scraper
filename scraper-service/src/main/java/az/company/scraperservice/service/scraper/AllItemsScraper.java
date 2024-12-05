package az.company.scraperservice.service.scraper;

import az.company.scraperservice.response.base.SearchItemsQueryResponse;
import az.company.scraperservice.service.rest.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import static az.company.scraperservice.constants.Constants.BASE_URL;

@Service
@RequiredArgsConstructor
public class AllItemsScraper {

    private static final String operationName = "SearchItemsQuery_16_BUMPED_AT_DESC_leasedfalse";
    private static final String variables = "{\"first\":20,\"filter\":{\"leased\":false},\"sort\":\"BUMPED_AT_DESC\"}";
    private static final String variablesWithCursor = "{\"first\":20,\"filter\":{\"leased\":false},\"sort\":\"BUMPED_AT_DESC\", \"cursor\": \"%s\"}";
    private static final String extensions = "{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"da607a702ba76a7f358f656836c447549c64812e36bc07e9914a6f2d9c246c0e\"}}";

    private final RestService restService;

    public SearchItemsQueryResponse scrap(String cursor) {
        String URL = "%s/graphql?%s".formatted(BASE_URL, getParams(cursor));
        return restService.get(URI.create(URL), SearchItemsQueryResponse.class);
    }

    public String getParams(String cursor) {
        try {
            return String.format("operationName=%s&variables=%s&extensions=%s",
                    URLEncoder.encode(operationName, "UTF-8"),
                    URLEncoder.encode(cursor == null ? variables : variablesWithCursor.formatted(cursor), "UTF-8"),
                    URLEncoder.encode(extensions, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            throw new RuntimeException("params not build");
        }
    }

}