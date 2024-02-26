package com.cabbookingapp.cabbookingappassignment.Dtos;

import com.cabbookingapp.cabbookingappassignment.Enums.Gender;
import com.cabbookingapp.cabbookingappassignment.Models.Location;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String username;
    private String name;
    private Gender gender;
    private int age;
    private Location location;

}