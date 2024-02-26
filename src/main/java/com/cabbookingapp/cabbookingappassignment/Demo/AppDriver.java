package com.cabbookingapp.cabbookingappassignment.Demo;

import com.cabbookingapp.cabbookingappassignment.Dtos.DriverDto;
import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Enums.Gender;
import com.cabbookingapp.cabbookingappassignment.Models.Location;
import com.cabbookingapp.cabbookingappassignment.Repository.DriverRepository;
import com.cabbookingapp.cabbookingappassignment.Repository.UserRepository;
import com.cabbookingapp.cabbookingappassignment.Service.*;


public class AppDriver {

    UserServiceImpl userService;
    DriverServiceImpl driverService;

    CabBookingServiceImpl cabBookingService;

    public AppDriver(UserServiceImpl userService, DriverServiceImpl driverService, CabBookingServiceImpl cabBookingService) {
        this.userService = userService;
        this.driverService = driverService;
        this.cabBookingService = cabBookingService;
    }

    void runTestCases() {
        // Onboard 3 users
        System.out.println("** Adding users **");
        userService.addUser( UserDto.builder().username("Abhishek").gender(Gender.MALE).age(23).location(new Location(0, 0)).build());
        userService.addUser( UserDto.builder().username("Rahul").gender(Gender.MALE).age(29).location(new Location(10, 0)).build());
        userService.addUser( UserDto.builder().username("Nandini").gender(Gender.FEMALE).age(22).location(new Location(15, 6)).build());

        // Test case 2: Onboard drivers
        System.out.println("** Adding drivers **");
        driverService.addDriver(DriverDto.builder().name("Driver1").gender(Gender.MALE).age(23).vehicleDetails("Swift, KA-01-12345").location(new Location(10, 1)).build());
        driverService.addDriver(DriverDto.builder().name("Driver2").gender(Gender.MALE).age(29).vehicleDetails("Swift, KA-01-12345").location(new Location(11, 10)).build());
        driverService.addDriver(DriverDto.builder().name("Driver3").gender(Gender.MALE).age(24).vehicleDetails("Swift, KA-01-12345").location(new Location(5, 3)).build());

        // Test case 3: Find rides
        System.out.println("** Finding rides **");
        System.out.println("Abhishek search: " + cabBookingService.findAvailableRides("Abhishek", new Location(0, 0), new Location(20, 1)));
        System.out.println("Rahul search: " + cabBookingService.findAvailableRides("Rahul", new Location(10, 0), new Location(15, 3)));
        System.out.println("Nandini search: " + cabBookingService.findAvailableRides("Nandini", new Location(15, 6), new Location(20, 4)));
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        DriverRepository driverRepository = new DriverRepository();
        DriverServiceImpl driverService = new DriverServiceImpl(driverRepository);
        CabBookingServiceImpl cabBookingService = new CabBookingServiceImpl(userService, driverService);
        AppDriver driver = new AppDriver(userService, driverService, cabBookingService);
        driver.runTestCases();
    }
}