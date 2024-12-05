package az.company.scraperservice.response.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetPhonesByItemResponse {

    @JsonProperty("phones")
    private List<String> phones;

}
