package com.cabbookingapp.cabbookingappassignment.Service;


import com.cabbookingapp.cabbookingappassignment.CustomExceptions.DriverNotFoundException;
import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import com.cabbookingapp.cabbookingappassignment.Models.Location;
import com.cabbookingapp.cabbookingappassignment.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabBookingServiceImpl implements CabBookingService{

    private final UserService userService;

    private final DriverService driverService;

    @Autowired
    public CabBookingServiceImpl(UserServiceImpl userService, DriverServiceImpl driverService) {
        this.userService = userService;
        this.driverService = driverService;
    }
    @Override
    public void addUser(UserDto userDto) {

    }

    public List<Driver> findAvailableRides(String username, Location source, Location destination) {
        User user = userService.getUserByUsername(username);
        List<Driver> availableDrivers = driverService.getAvailableDrivers();

        List<Driver> nearbyDrivers = availableDrivers.stream()
                .filter(driver -> driver.getCurrentLocation().calculateDistance(user.getCurrentLocation()) <= 5)
                .collect(Collectors.toList());

        return nearbyDrivers;
    }

    @Override
    public Driver chooseRide(String username, String driverName) {
        User user = userService.getUserByUsername(username);
        Driver driver = driverService.getDriverByName(driverName);

        if (driver == null) {
            throw new DriverNotFoundException(driverName);
        }

        System.out.println("Ride booked for " + user.getName() + " with driver " + driver.getName());

        return driver;
    }
}
