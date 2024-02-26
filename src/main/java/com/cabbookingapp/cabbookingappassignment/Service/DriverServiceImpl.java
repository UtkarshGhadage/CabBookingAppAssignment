package com.cabbookingapp.cabbookingappassignment.Service;

import com.cabbookingapp.cabbookingappassignment.Converter.DriverConvertor;
import com.cabbookingapp.cabbookingappassignment.Dtos.DriverDto;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;
import com.cabbookingapp.cabbookingappassignment.Repository.DriverRepository;
import com.cabbookingapp.cabbookingappassignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void addDriver(DriverDto driverDto) {
        Driver driver = DriverConvertor.convertDtoToEntity(driverDto);
        driverRepository.save(driver);
    }

    @Override
    public Driver getDriverByName(String driverName) {
        return  driverRepository.getDriver(driverName);
    }

    @Override
    public List<Driver> getAvailableDrivers() {
        return driverRepository.getAll();
    }
}