package com.cabbookingapp.cabbookingappassignment.Converter;

import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Models.User;

public class UserConverter{
    
    public static User convertDtoToEntity(UserDto userDto){
        return User.builder()
                .name(userDto.getUsername())
                .gender(userDto.getGender())
                .age(userDto.getAge())
                .currentLocation(userDto.getLocation())
                .build();
    }
}
