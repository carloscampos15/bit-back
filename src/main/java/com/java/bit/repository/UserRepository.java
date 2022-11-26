package com.java.bit.repository;

import com.java.bit.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByEmail(String email);

}
