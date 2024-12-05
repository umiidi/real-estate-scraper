package az.company.apiservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long adId;

    private String url;

    private Long price;
    private String currency;

    private String locationName;

    private Double latitude;

    private Double longitude;

    private LocalDateTime dateTime;

    private String belongs;

    private String typeOfRealEstate;

    private String ownerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Number> numbers;

    @Lob
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Image> images;

    private String city;

    private String district;

    private Double area;
    private String areaUnits;

    private Double landArea;
    private String landAreaUnits;

    private Boolean cixariw;

    private Integer rooms;

    private Boolean renovated;

    private Integer floor;

    private Integer floors;

}
