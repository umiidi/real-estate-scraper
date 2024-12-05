package az.company.apiservice.service.ad;

import az.company.apiservice.entity.Ad;
import az.company.apiservice.enums.AdSortBy;
import az.company.apiservice.kafka.event.AdsEvent;
import az.company.apiservice.repository.AdRepository;
import az.company.apiservice.specification.AdCriteria;
import az.company.apiservice.specification.AdSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import static az.company.apiservice.mapper.AdMapper.AD_MAPPER;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;

    public PagedModel<Ad> filter(AdCriteria criteria, int page, int size, AdSortBy sortBy) {
        Pageable pageable = PageRequest.of(page, size, getSort(sortBy));
        Specification<Ad> spec = Specification.where(AdSpecification.filter(criteria));
        return new PagedModel<>(adRepository.findAll(spec, pageable));
    }

    private Sort getSort(AdSortBy sortBy) {
        return switch (sortBy) {
            case BY_DATE_ASC -> Sort.by(Sort.Order.asc("dateTime"));
            case BY_DATE_DESC -> Sort.by(Sort.Order.desc("dateTime"));
        };
    }

    public void save(AdsEvent event) {
        if (adRepository.existsByAdId(event.getId())) return;

        Ad ad = AD_MAPPER.mapToAdEntity(event);
        adRepository.save(ad);
    }

}
