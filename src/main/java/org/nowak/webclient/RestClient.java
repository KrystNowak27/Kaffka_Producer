package org.nowak.webclient;

import org.nowak.dto.ClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestClient {
    @Value("${spring.rest-client.url}")
    public  String url;

    private final RestTemplate restTemplate = new RestTemplate();

    public ClientResponse getDataFromConsumer(Long id) {
        String endpoint = String.format("/%d", id);
        return callGetMethod(endpoint, ClientResponse.class);
    }

    public List<ClientResponse> getAllClients() {
        ResponseEntity<ClientResponse[]> response = restTemplate.getForEntity(url, ClientResponse[].class);
        return Arrays.asList(response.getBody());
    }

    private <T> T callGetMethod(String url, Class<T> responseType) {
        return restTemplate.getForObject(this.url + url, responseType);
    }
}


