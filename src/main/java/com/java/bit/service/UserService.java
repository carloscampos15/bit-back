package com.java.bit.service;

import com.java.bit.model.User;

public interface UserService {

    public User findByEmail(String email);

}
