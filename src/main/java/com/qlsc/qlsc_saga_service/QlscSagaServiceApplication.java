package com.qlsc.qlsc_saga_service;

import com.qlsc.qlsc_common.constant.KafkaConstant;
import com.qlsc.qlsc_common.event.TestEvent;
import com.qlsc.qlsc_saga_service.service.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class QlscSagaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlscSagaServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaProducerService kafkaProducerService) {
        return args -> {
            int random;
            for (int i = 0; i < 1000; i++) {
                random = new Random().nextInt(3);
                TestEvent testEvent = TestEvent
                        .builder()
                        .id(String.valueOf(random))
                        .data("DATA")
                        .build();
//                kafkaProducerService.sendEventV2(KafkaConstant.TOPIC_BOOKING_EVENT,
//                random, testEvent.getId(), testEvent
//                );
            }
        };
    }

}
