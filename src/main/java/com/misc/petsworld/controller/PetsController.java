package com.misc.petsworld.controller;

import com.example.client.model.Pet;
import com.misc.petsworld.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/pets")
@RestController
public class PetsController {

    @Autowired
    PetsService petsService;

    @GetMapping
    public List<Pet> getPetsByStatus(@RequestParam(name = "status", required = true, defaultValue = "available") String status) {
        return petsService.getPet(status);
    }
}
