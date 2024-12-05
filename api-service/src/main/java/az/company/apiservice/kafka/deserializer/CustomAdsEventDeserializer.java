package az.company.apiservice.kafka.deserializer;

import az.company.apiservice.kafka.event.AdsEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class CustomAdsEventDeserializer implements Deserializer<AdsEvent> {

    @Override
    public AdsEvent deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(bytes, AdsEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
