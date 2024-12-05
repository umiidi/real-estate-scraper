package az.company.scraperservice.mapper;

import az.company.scraperservice.event.AdsEvent;
import az.company.scraperservice.response.inner.item.Item;
import az.company.scraperservice.response.inner.item.Photo;

import java.util.List;

import static az.company.scraperservice.constants.Constants.BASE_URL;

public enum AdsEventMapper {

    ADS_EVENT_MAPPER;

    // TODO: optimize this code
    public AdsEvent mapToAdsEvent(Item item, List<String> phones) {
        String url = String.format("%s%s", BASE_URL, item.getPath());

        List<String> images = item.getPhotos()
                .stream()
                .map(Photo::getFull)
                .toList();

        String district = item.getNearestLocations().isEmpty()
                ? item.getLocation().getFullName()
                : item.getNearestLocations().get(0).getFullName();

        String city = item.getCity() != null ? item.getCity().getName() : null;

        Double area = item.getArea() != null ? item.getArea().getValue() : null;
        String areaUnits = item.getArea() != null ? item.getArea().getUnits() : null;

        Double landArea = item.getLandArea() != null ? item.getLandArea().getValue() : null;
        String landAreaUnits = item.getLandArea() != null ? item.getLandArea().getUnits() : null;

        return AdsEvent.builder()
                .id(item.getId())
                .url(url)
                .price(item.getPrice().getValue())
                .currency(item.getPrice().getCurrency())
                .locationName(item.getAddress())
                .latitude(item.getLatitude())
                .longitude(item.getLongitude())
                .dateTime(item.getUpdatedAt())
                .belongs(item.getContactTypeName())
                .typeOfRealEstate(item.getCategory().getName())
                .ownerName(item.getContactName())
                .numbers(phones)
                .description(item.getDescription())
                .images(images)
                .city(city)
                .district(district)
                .area(area)
                .areaUnits(areaUnits)
                .landArea(landArea)
                .landAreaUnits(landAreaUnits)
                .hasBillOfSale(item.getHasBillOfSale())
                .rooms(item.getRooms())
                .renovated(item.getHasRepair())
                .floor(item.getFloor())
                .floors(item.getFloors())
                .build();

    }


}
