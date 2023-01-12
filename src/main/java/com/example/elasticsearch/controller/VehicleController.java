package com.example.elasticsearch.controller;

import com.example.elasticsearch.document.Vehicle;
import com.example.elasticsearch.search.SearchRequestDTO;
import com.example.elasticsearch.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody final SearchRequestDTO dto) {
        return vehicleService.search(dto);
    }

    @GetMapping("/search/{date}")
    public List<Vehicle> getAllVehiclesCreatedSince(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
        return vehicleService.getAllVehiclesCreateSince(date);
    }
}
