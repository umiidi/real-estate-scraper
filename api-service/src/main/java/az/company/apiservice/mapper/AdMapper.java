package az.company.apiservice.mapper;

import az.company.apiservice.entity.Ad;
import az.company.apiservice.entity.Image;
import az.company.apiservice.entity.Number;
import az.company.apiservice.kafka.event.AdsEvent;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum AdMapper {

    AD_MAPPER;

    public Ad mapToAdEntity(AdsEvent event) {
        return Ad.builder()
                .adId(event.getId())
                .url(event.getUrl())
                .price(event.getPrice())
                .currency(event.getCurrency())
                .locationName(event.getLocationName())
                .latitude(event.getLatitude())
                .longitude(event.getLongitude())
                .dateTime(OffsetDateTime
                        .parse(event.getDateTime(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        .toLocalDateTime())
                .belongs(event.getBelongs())
                .typeOfRealEstate(event.getTypeOfRealEstate())
                .ownerName(event.getOwnerName())
                .numbers(mapToNumberEntitySet(event.getNumbers()))
                .description(event.getDescription())
                .images(mapToImageEntitySet(event.getImages()))
                .city(event.getCity())
                .district(event.getDistrict())
                .area(event.getArea())
                .areaUnits(event.getAreaUnits())
                .landArea(event.getLandArea())
                .landAreaUnits(event.getLandAreaUnits())
                .cixariw(event.getHasBillOfSale())
                .rooms(event.getRooms())
                .renovated(event.getRenovated())
                .floor(event.getFloor())
                .floors(event.getFloors())
                .build();
    }

    Set<Number> mapToNumberEntitySet(List<String> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toSet());
    }

    Set<Image> mapToImageEntitySet(List<String> images) {
        return images.stream()
                .map(Image::new)
                .collect(Collectors.toSet());
    }

}
