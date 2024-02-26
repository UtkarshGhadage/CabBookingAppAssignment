package com.cabbookingapp.cabbookingappassignment.Service;

import com.cabbookingapp.cabbookingappassignment.Dtos.DriverDto;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DriverService {

    void addDriver(DriverDto driverDto);

    Driver getDriverByName(String driverName);

    List<Driver> getAvailableDrivers();

}
