package org.nowak.controller;

import org.nowak.dto.ClientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class DummyController {

    @GetMapping("/dummy")

    public ClientResponse getDummyClient(){
         return  ClientResponse.builder()
                .name("test")
                .surname("test")
                .email("test@2.pl")
                .build();
    }

}

