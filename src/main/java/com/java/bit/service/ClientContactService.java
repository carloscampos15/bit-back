package com.java.bit.service;

import com.java.bit.dto.ClientContactDto;
import com.java.bit.dto.ClientContactRsDto;

import java.util.List;
import java.util.Optional;

public interface ClientContactService {

    public void saveClientContact(ClientContactDto clientContactDto);

    public Optional<ClientContactRsDto> updateClientContact(Long clientId, ClientContactDto clientContactDto);

    public List<ClientContactRsDto> getClientContacts();

    public Optional<ClientContactRsDto> getClientContactById(Long clientContactId);

    public void deleteClientContactById(Long clientContactId);

}
