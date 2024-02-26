package com.cabbookingapp.cabbookingappassignment.Controller;

import com.cabbookingapp.cabbookingappassignment.Dtos.DriverDto;
import com.cabbookingapp.cabbookingappassignment.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/login")
    public ResponseEntity<Void> addDriver(@RequestBody DriverDto driverDto) {
        driverService.addDriver(driverDto);
        return ResponseEntity.ok().build();
    }
}
