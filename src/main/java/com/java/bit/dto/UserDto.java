package com.java.bit.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String lastname;
    private LocalDateTime lastLogin;

}
