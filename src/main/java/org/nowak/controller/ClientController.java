package org.nowak.controller;

import lombok.RequiredArgsConstructor;
import org.nowak.dto.ClientResponse;
import org.nowak.webclient.RestClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Profile("prod")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class ClientController {

    private final RestClient restClient;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable Long id) {
        ClientResponse client = restClient.getDataFromConsumer(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clients = restClient.getAllClients();
        if (!clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
