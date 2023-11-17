package org.nowak.controller;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientRequest;
import org.nowak.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducer;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ClientRequest client) {
        kafkaProducer.sendMessage(client);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}