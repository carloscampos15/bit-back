package com.java.bit.dto;

import com.java.bit.model.Client;
import lombok.Data;

@Data
public class ClientContactRsDto {

    private Long id;
    private String name;
    private String email;
    private Client client;

}
