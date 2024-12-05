package az.company.apiservice.specification;

import az.company.apiservice.entity.Ad;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AdSpecification {

    public static Specification<Ad> filter(AdCriteria criteria) {
        return (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>(10);

            if (query.getResultType() != Long.class) {
                root.fetch("numbers", JoinType.LEFT);
                root.fetch("images", JoinType.LEFT);
                query.distinct(true);
            }

            // price
            if (isNotNull(criteria.getMinPrice()))
                list.add(builder
                        .greaterThanOrEqualTo(root.get(Ad.Fields.price), criteria.getMinPrice()));
            if (isNotNull(criteria.getMaxPrice()))
                list.add(builder
                        .lessThanOrEqualTo(root.get(Ad.Fields.price), criteria.getMaxPrice()));

            // area
            if (isNotNull(criteria.getMinArea()))
                list.add(builder
                        .greaterThanOrEqualTo(root.get(Ad.Fields.area), criteria.getMinArea()));
            if (isNotNull(criteria.getMaxArea()))
                list.add(builder
                        .lessThanOrEqualTo(root.get(Ad.Fields.area), criteria.getMaxArea()));

            // land area
            if (isNotNull(criteria.getMinLandArea()))
                list.add(builder
                        .greaterThanOrEqualTo(root.get(Ad.Fields.landArea), criteria.getMinLandArea()));
            if (isNotNull(criteria.getMaxLandArea()))
                list.add(builder
                        .lessThanOrEqualTo(root.get(Ad.Fields.landArea), criteria.getMaxLandArea()));

            // rooms
            if (isNotNull(criteria.getNumberOfRooms()))
                list.add(builder
                        .equal(root.get(Ad.Fields.rooms), criteria.getNumberOfRooms()));

            // floors
            if (isNotNull(criteria.getNumberOfFloor()))
                list.add(builder
                        .equal(root.get(Ad.Fields.floor), criteria.getNumberOfFloor()));

            // cixariw
            if (isNotNull(criteria.getCixariw()))
                list.add(builder
                        .equal(root.get(Ad.Fields.cixariw), criteria.getCixariw()));

            // city
            if (isNotNull(criteria.getCity()) && !criteria.getCity().isEmpty())
                list.add(builder
                        .like(root.get(Ad.Fields.city), String.format("%%%s%%", criteria.getCity())));

            // district
            if (isNotNull(criteria.getDistrict()) && !criteria.getDistrict().isEmpty())
                list.add(builder
                        .like(root.get(Ad.Fields.district), String.format("%%%s%%", criteria.getDistrict())));

            return builder.and(list.toArray(Predicate[]::new));
        };
    }

    private static boolean isNotNull(Object object) {
        return object != null;
    }


}
