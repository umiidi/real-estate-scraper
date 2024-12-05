package az.company.apiservice.kafka.event;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AdsEvent {

    private Long id;

    private String url;

    private Long  price;
    private String currency;

    private String locationName;

    private Double latitude;

    private Double longitude;

    private String dateTime;

    private String belongs;

    private String typeOfRealEstate;

    private String ownerName;

    private List<String> numbers;

    private String description;

    private List<String> images;

    private String city;

    private String district;

    private Double area;
    private String areaUnits;

    private Double landArea;
    private String landAreaUnits;

    private Boolean hasBillOfSale;

    private Integer rooms;

    private Boolean renovated;

    private Integer floor;

    private Integer floors;

}