package com.cabbookingapp.cabbookingappassignment.Models;

import com.cabbookingapp.cabbookingappassignment.Enums.Avaliability;
import com.cabbookingapp.cabbookingappassignment.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    private String name;
    private Gender gender;
    private int age;
    private Location currentLocation;
    private String vehicleDetails;
    private Avaliability available;
}