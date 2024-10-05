package com.misc.petsworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PetsService {

    @Autowired
    RestTemplate restTemplate;

    public String getPetsByStatus(String status) {
        String findByStatusUrl = "https://petstore.swagger.io/v2/pet/findByStatus?status=" + status;

        return restTemplate.getForObject(findByStatusUrl, String.class);
    }
}
