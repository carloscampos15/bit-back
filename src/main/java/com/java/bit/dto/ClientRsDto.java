package com.java.bit.dto;

import com.java.bit.model.Sector;
import com.java.bit.model.User;
import lombok.Data;

@Data
public class ClientRsDto {

    private Long id;
    private String name;
    private String email;
    private String nit;
    private String address;
    private String city;
    private User user;
    private Sector sector;


}
