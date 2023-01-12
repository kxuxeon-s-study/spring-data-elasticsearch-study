package com.example.elasticsearch.service;

import com.example.elasticsearch.document.Vehicle;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class VehicleDummyDataService {
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final VehicleService vehicleService;

    public void insertDummyData() {
        vehicleService.index(buildVehicle("1", "Audi A1", "AAA-123", "2010-01-01"));
        vehicleService.index(buildVehicle("2", "Audi A2", "AAB-123", "2011-07-05"));
        vehicleService.index(buildVehicle("3", "Audi A3", "AAC-123", "2012-10-03"));

        vehicleService.index(buildVehicle("4", "BMW M3", "AAA-023", "2021-10-16"));
        vehicleService.index(buildVehicle("5", "BMW 3", "1AA-023", "2001-10-01"));
        vehicleService.index(buildVehicle("6", "BMW M5", "12A-023", "1999-05-08"));

        vehicleService.index(buildVehicle("7", "VW Golf", "42A-023", "1994-06-15"));
        vehicleService.index(buildVehicle("8", "VW Passat", "18A-023", "2022-02-01"));

        vehicleService.index(buildVehicle("9", "KIA K7", "28A-023", "2020-05-03"));
        vehicleService.index(buildVehicle("10", "KIA K9", "88A-023", "2023-01-05"));
    }

    private static Vehicle buildVehicle(final String id,
                                        final String name,
                                        final String number,
                                        final String created) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setName(name);
        vehicle.setNumber(number);
        try {
            vehicle.setCreated(DATE_FORMAT.parse(created));
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return vehicle;
    }

}
