package com.qlsc.qlsc_saga_service.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaProducerService {

    KafkaTemplate<String, Object> kafkaTemplate;
    Logger LOG = LoggerFactory.getLogger(this.getClass());

    public void sendEvent(String topic, String key, Object event) {
        kafkaTemplate.send(topic, key, event);
        System.out.printf("✅ Sent event to %s: %s%n", topic, event);
    }

    public void sendEventV2(String topic, Integer partition, String key, Object event) {
        kafkaTemplate.send(topic, partition, key, event);
        System.out.printf("✅ Sent event to %s: %s%n", topic, event);
    }
}
