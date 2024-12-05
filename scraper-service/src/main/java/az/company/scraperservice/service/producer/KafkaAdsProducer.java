package az.company.scraperservice.service.producer;

import az.company.scraperservice.entity.AdIds;
import az.company.scraperservice.event.AdsEvent;
import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static az.company.scraperservice.config.kafka.KafkaTopicConfig.TOPIC_ADS;

@Component
@RequiredArgsConstructor
public class KafkaAdsProducer {

    private final KafkaTemplate<Long, Object> kafkaTemplate;

    public void send(AdsEvent event) {
        kafkaTemplate.send(TOPIC_ADS, event.getId(), event);
    }

    public void send(AdIds event) {
        kafkaTemplate.send(TOPIC_ADS, event);
    }

}
