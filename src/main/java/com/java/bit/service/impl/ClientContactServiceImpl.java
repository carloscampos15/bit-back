package com.java.bit.service.impl;

import com.java.bit.dto.ClientContactDto;
import com.java.bit.dto.ClientContactRsDto;
import com.java.bit.model.Client;
import com.java.bit.model.ClientContact;
import com.java.bit.repository.ClientContactRepository;
import com.java.bit.repository.ClientRepository;
import com.java.bit.service.ClientContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientContactServiceImpl implements ClientContactService {

    @Autowired
    private ClientContactRepository clientContactRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveClientContact(ClientContactDto clientContactDto) {
        ClientContact clientContact = modelMapper.map(clientContactDto, ClientContact.class);
        Optional<Client> client = clientRepository.findById(clientContactDto.getClient());

        if (client.isPresent()) {
            clientContact.setClient(client.get());

            clientContactRepository.save(clientContact);
        }
    }

    @Override
    public Optional<ClientContactRsDto> updateClientContact(Long clientId, ClientContactDto clientContactDto) {
        Optional<ClientContact> clientContact = clientContactRepository.findById(clientId);
        if (clientContact.isPresent()) {
            Optional<Client> client = clientRepository.findById(clientContactDto.getClient());

            if (client.isPresent()) {
                clientContact.get().setClient(client.get());
                clientContact.get().setName(clientContactDto.getName());
                clientContact.get().setEmail(clientContactDto.getEmail());

                ClientContact updated = clientContactRepository.save(clientContact.get());

                return Optional.of(modelMapper.map(updated, ClientContactRsDto.class));
            }
        }

        return Optional.empty();
    }

    @Override
    public List<ClientContactRsDto> getClientContacts() {
        List<ClientContactRsDto> clientContacts = new ArrayList<>();

        clientContactRepository.findAll()
                .forEach(clientContact -> clientContacts.add(modelMapper.map(clientContact, ClientContactRsDto.class)));

        return clientContacts;
    }

    @Override
    public Optional<ClientContactRsDto> getClientContactById(Long clientContactId) {
        Optional<ClientContact> clientContact = clientContactRepository.findById(clientContactId);

        if (clientContact.isPresent()) {
            return Optional.of(modelMapper.map(clientContact, ClientContactRsDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void deleteClientContactById(Long clientContactId) {
        clientContactRepository.deleteById(clientContactId);
    }
}
