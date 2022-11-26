package com.java.bit.service;

import com.java.bit.dto.ClientDto;
import com.java.bit.dto.ClientRsDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public void saveClient(ClientDto clientDto);

    public Optional<ClientRsDto> updateClient(Long clientId, ClientDto clientDto);

    public List<ClientRsDto> getClients();

    public Optional<ClientRsDto> getClientById(Long clientId);

    public void deleteClientById(Long clientId);

}
