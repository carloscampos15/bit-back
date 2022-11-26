package com.java.bit.controller;

import com.java.bit.dto.UserDto;
import com.java.bit.model.User;
import com.java.bit.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/profile")
    public UserDto getUserProfile(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        return modelMapper.map(user, UserDto.class);
    }

}
