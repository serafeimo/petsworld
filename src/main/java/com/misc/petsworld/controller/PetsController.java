package com.misc.petsworld.controller;

import com.misc.petsworld.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/pets")
@RestController
public class PetsController {

    @Autowired
    PetsService petsService;

    @GetMapping
    public String getPetsByStatus(@RequestParam(name = "status", required = true, defaultValue = "available") String status) {
        return petsService.getPetsByStatus(status);
    }
}
