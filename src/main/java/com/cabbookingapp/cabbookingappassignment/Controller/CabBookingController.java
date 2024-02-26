package com.cabbookingapp.cabbookingappassignment.Controller;

import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Enums.Avaliability;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import com.cabbookingapp.cabbookingappassignment.Models.Location;
import com.cabbookingapp.cabbookingappassignment.Repository.DriverRepository;
import com.cabbookingapp.cabbookingappassignment.Service.CabBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-ride")
public class CabBookingController {

    @Autowired
    CabBookingService cabBookingService;

    @Autowired
    DriverRepository driverRepository;

    @PostMapping("/login")
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto) {
        cabBookingService.addUser(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rides/{username}")
    public ResponseEntity<List<Driver>> findAvailableRides(@PathVariable String username, @RequestParam Location source, @RequestParam Location destination) {
        List<Driver> drivers = cabBookingService.findAvailableRides(username, source, destination);

        return ResponseEntity.ok(drivers);
    }

    @PostMapping
    public void confirmRide(String driverName){
        Driver driver = driverRepository.getDriver(driverName);
        driver.setAvailable(Avaliability.BUSY);

        System.out.println("Your ride is on the way");
        System.out.println("Driver: " + driverName);
        System.out.println("Ride Details: " + driver.getVehicleDetails());
    }

}