package com.cabbookingapp.cabbookingappassignment.Service;


import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Models.User;


public interface UserService {

    void addUser(UserDto userDto);
    User getUserByUsername(String username);
}
