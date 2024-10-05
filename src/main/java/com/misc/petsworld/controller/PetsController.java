package com.misc.petsworld.controller;

import com.misc.petsworld.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsController {

    @Autowired
    PetsService petsService;

    @GetMapping("/pets")
    public String getPets() {
        return petsService.getPet();
    }
}
