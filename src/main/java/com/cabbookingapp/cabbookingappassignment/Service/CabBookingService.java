package com.cabbookingapp.cabbookingappassignment.Service;

import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import com.cabbookingapp.cabbookingappassignment.Models.Location;


import java.util.List;

public interface CabBookingService {
    void addUser(UserDto userDto);

    List<Driver> findAvailableRides(String username, Location source, Location destination);

    Driver chooseRide(String username, String driverName);
}
