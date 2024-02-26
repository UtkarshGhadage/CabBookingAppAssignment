package com.cabbookingapp.cabbookingappassignment.Repository;

import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DriverRepository {
    private Map<String, Driver> drivers = new HashMap<>();;

    public void save(Driver driver) {
        drivers.put(driver.getName(), driver);
    }

    public Driver getDriver(String driverName){
        return drivers.get(driverName);
    }

    public List<Driver> getAll() {
        return new ArrayList<>(drivers.values());
    }

}