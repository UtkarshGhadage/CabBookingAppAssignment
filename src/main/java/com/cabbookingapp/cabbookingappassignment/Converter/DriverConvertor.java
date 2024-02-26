package com.cabbookingapp.cabbookingappassignment.Converter;


import com.cabbookingapp.cabbookingappassignment.Dtos.DriverDto;
import com.cabbookingapp.cabbookingappassignment.Models.Driver;

public class DriverConvertor{
    public static Driver convertDtoToEntity(DriverDto driverDto){

        return Driver.builder()
                .name(driverDto.getName())
                .gender(driverDto.getGender())
                .age(driverDto.getAge())
                .currentLocation(driverDto.getLocation())
                .vehicleDetails(driverDto.getVehicleDetails())
                .available(driverDto.getAvailable())
                .build();
    }
}