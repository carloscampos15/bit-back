package com.java.bit.repository;

import com.java.bit.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
}
