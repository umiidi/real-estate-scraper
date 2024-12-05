package az.company.scraperservice.response.inner.itemsconnection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsConnection {

    @JsonProperty("totalCount")
    private long totalCount;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    @JsonProperty("edges")
    private List<Edge> edges;

}
