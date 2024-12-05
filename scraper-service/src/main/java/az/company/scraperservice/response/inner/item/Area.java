package az.company.scraperservice.response.inner.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Area {

    @JsonProperty("value")
    private double value;

    @JsonProperty("units")
    private String units;

}
