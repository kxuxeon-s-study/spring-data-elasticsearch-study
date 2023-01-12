package com.example.elasticsearch.controller;

import com.example.elasticsearch.document.Vehicle;
import com.example.elasticsearch.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public void save(@RequestBody final Vehicle vehicle) {
        vehicleService.save(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable final String id) {
        return vehicleService.findById(id);
    }
}
