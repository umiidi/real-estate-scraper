package az.company.scraperservice.response.inner.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @JsonProperty("value")
    private long value;

    @JsonProperty("currency")
    private String currency;

}
