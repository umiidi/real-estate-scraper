package az.company.scraperservice.response.base;

import az.company.scraperservice.response.inner.item.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetItemResponse {

    @JsonProperty("data")
    private Data data;

    @lombok.Data
    public static class Data {

        @JsonProperty("item")
        private Item item;

    }

}
