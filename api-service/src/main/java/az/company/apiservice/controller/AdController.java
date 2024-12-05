package az.company.apiservice.controller;

import az.company.apiservice.entity.Ad;
import az.company.apiservice.enums.AdSortBy;
import az.company.apiservice.service.ad.AdService;
import az.company.apiservice.specification.AdCriteria;
import lombok.RequiredArgsConstructor;

import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ads")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @GetMapping("/filter")
    public ResponseEntity<PagedModel<Ad>> filter(@RequestParam int page,
                                                 @RequestParam int size,
                                                 @RequestParam(defaultValue = "BY_DATE_DESC") AdSortBy sortBy,
                                                 @ModelAttribute AdCriteria criteria) {
        return ResponseEntity.ok(adService.filter(criteria, page, size, sortBy));
    }

}
