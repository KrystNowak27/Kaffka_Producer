package org.nowak.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nowak.dto.ClientRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private final KafkaTemplate<String, ClientRequest> kafkaTemplate;

    public void sendMessage(ClientRequest data){
        log.info(String.format("Message sent -> %s", data.toString()));
        kafkaTemplate.send(topicJsonName, data);
    }
}