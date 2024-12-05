package az.company.apiservice.repository;

import az.company.apiservice.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdRepository extends JpaRepository<Ad, Long>, JpaSpecificationExecutor<Ad> {

    boolean existsByAdId(Long adId);

}
