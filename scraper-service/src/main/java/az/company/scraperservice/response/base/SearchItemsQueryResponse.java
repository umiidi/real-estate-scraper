package az.company.scraperservice.response.base;

import az.company.scraperservice.response.inner.itemsconnection.ItemsConnection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchItemsQueryResponse {

    @JsonProperty("data")
    private Data data;

    @lombok.Data
    public static class Data {

        @JsonProperty("itemsConnection")
        private ItemsConnection itemsConnection;

    }

}
