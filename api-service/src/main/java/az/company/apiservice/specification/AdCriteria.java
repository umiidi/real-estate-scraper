package az.company.apiservice.specification;

import lombok.Data;

@Data
public class AdCriteria {

    private Long minPrice;
    private Long maxPrice;

    private Long minArea;
    private Long maxArea;

    private Long minLandArea;
    private Long maxLandArea;

    private Long numberOfRooms;

    private Long numberOfFloor;

    private Boolean cixariw;

    private String city;

    private String district;

}
