package az.company.scraperservice.response.inner.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
