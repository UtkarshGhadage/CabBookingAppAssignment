package com.cabbookingapp.cabbookingappassignment.CustomExceptions;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(String driverName) {
        super("Driver not found: " + driverName);
    }
}
