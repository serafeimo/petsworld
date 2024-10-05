package com.misc.petsworld.service;

import com.example.client.api.PetApi;
import com.example.client.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PetsService {

    @Autowired
    private PetApi petApi;

    public List<Pet> getPet(String status) {
        return petApi.findPetsByStatus(Arrays.asList(status));
    }
}
