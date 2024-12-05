package az.company.scraperservice.response.inner.itemsconnection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {

    @JsonProperty("id")
    private Long id;

}
