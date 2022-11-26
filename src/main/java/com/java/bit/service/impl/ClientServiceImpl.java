package com.java.bit.service.impl;

import com.java.bit.dto.ClientDto;
import com.java.bit.dto.ClientRsDto;
import com.java.bit.model.Client;
import com.java.bit.model.Sector;
import com.java.bit.model.User;
import com.java.bit.repository.ClientRepository;
import com.java.bit.repository.SectorRepository;
import com.java.bit.repository.UserRepository;
import com.java.bit.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        Optional<User> user = userRepository.findById(clientDto.getUser());
        Optional<Sector> sector = sectorRepository.findById(clientDto.getSector());

        if (user.isPresent() && sector.isPresent()) {
            client.setUser(user.get());
            client.setSector(sector.get());

            clientRepository.save(client);
        }
    }

    @Override
    public Optional<ClientRsDto> updateClient(Long clientId, ClientDto clientDto) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            Optional<User> user = userRepository.findById(clientDto.getUser());
            Optional<Sector> sector = sectorRepository.findById(clientDto.getSector());

            if (user.isPresent() && sector.isPresent()) {
                client.get().setName(clientDto.getName());
                client.get().setCity(clientDto.getCity());
                client.get().setEmail(clientDto.getEmail());
                client.get().setAddress(clientDto.getAddress());
                client.get().setNit(clientDto.getAddress());

                client.get().setUser(user.get());
                client.get().setSector(sector.get());

                Client updated = clientRepository.save(client.get());

                return Optional.of(modelMapper.map(updated, ClientRsDto.class));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<ClientRsDto> getClients() {
        List<ClientRsDto> clients = new ArrayList<>();

        clientRepository.findAll()
                .forEach(client -> clients.add(modelMapper.map(client, ClientRsDto.class)));

        return clients;
    }

    @Override
    public Optional<ClientRsDto> getClientById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isPresent()) {
            return Optional.of(modelMapper.map(client, ClientRsDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
