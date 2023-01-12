package com.example.elasticsearch.controller;

import com.example.elasticsearch.document.Vehicle;
import com.example.elasticsearch.search.SearchRequestDTO;
import com.example.elasticsearch.service.VehicleDummyDataService;
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
    private final VehicleService service;
    private final VehicleDummyDataService vehicleDummyDataService;


    @PostMapping
    public void index(@RequestBody final Vehicle vehicle) {
        service.index(vehicle);
    }

    @PostMapping("/insert-dummy-data")
    public void insertDummyData() {
        vehicleDummyDataService.insertDummyData();
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable final String id) {
        return service.findById(id);
    }

    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody final SearchRequestDTO dto) {
        return service.search(dto);
    }

    @GetMapping("/search/{date}")
    public List<Vehicle> getAllVehiclesCreatedSince(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
        return service.getAllVehiclesCreateSince(date);
    }

    @PostMapping("/search-created-since/{date}")
    public List<Vehicle> searchCreatedSince(@RequestBody final SearchRequestDTO dto,
                                            @PathVariable
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
        return service.searchCreatedSince(dto, date);
    }
}
