package az.company.scraperservice.service.scheduler;

import az.company.scraperservice.service.ads.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdsScheduler {

    private final AdsService adsService;

    @Scheduled(fixedDelay = 600_000) // 10 minute
    public void run() {
        adsService.adsScrapAndProduce();
    }

}