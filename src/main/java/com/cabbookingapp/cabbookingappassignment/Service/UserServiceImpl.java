package com.cabbookingapp.cabbookingappassignment.Service;

import com.cabbookingapp.cabbookingappassignment.Converter.UserConverter;
import com.cabbookingapp.cabbookingappassignment.Dtos.UserDto;
import com.cabbookingapp.cabbookingappassignment.Models.User;
import com.cabbookingapp.cabbookingappassignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserDto userDto) {
        User user = UserConverter.convertDtoToEntity(userDto);
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}