package az.company.scraperservice.repository;

import az.company.scraperservice.entity.AdIds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdIdsRepository extends JpaRepository<AdIds, Long> {

    boolean existsByAdId(Long id);

}
