package az.company.scraperservice.response.inner.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private Price price;

    @JsonProperty("city")
    private City city;

    @JsonProperty("photos")
    private List<Photo> photos;

    @JsonProperty("area")
    private Area area;

    @JsonProperty("landArea")
    private Area landArea;

    @JsonProperty("rooms")
    private Integer rooms;

    @JsonProperty("floor")
    private Integer floor;

    @JsonProperty("floors")
    private Integer floors;

    @JsonProperty("hasBillOfSale")
    private Boolean hasBillOfSale;   // cixariw

    @JsonProperty("hasMortgage")
    private Boolean hasMortgage;    // ipoteka

    @JsonProperty("hasRepair")
    private Boolean hasRepair;    // renovated

    @JsonProperty("nearestLocations")
    private List<Location> nearestLocations;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("contactName")
    private String contactName;

    @JsonProperty("contactTypeName")
    private String contactTypeName;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("path")
    private String path;

}
