package com.java.bit.repository;

import com.java.bit.model.ClientContact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientContactRepository extends PagingAndSortingRepository<ClientContact, Long> {
}
