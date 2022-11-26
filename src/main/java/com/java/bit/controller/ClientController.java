package com.java.bit.controller;

import com.java.bit.dto.ClientDto;
import com.java.bit.dto.ClientRsDto;
import com.java.bit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<ClientRsDto>> getClients() {
        return ResponseEntity.status(HttpStatus.OK).body(
                clientService.getClients()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientRsDto> getClient(@PathVariable("id") Long clientId) {
        Optional<ClientRsDto> client = clientService.getClientById(clientId);

        return client
                .map(clientDto -> ResponseEntity.status(HttpStatus.OK).body(clientDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Boolean> saveClient(@RequestBody ClientDto clientDto) {
        clientService.saveClient(clientDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientRsDto> updateClient(@PathVariable("id") Long clientId, @RequestBody ClientDto clientDto) {
        Optional<ClientRsDto> client = clientService.updateClient(clientId, clientDto);

        return client
                .map(updated -> ResponseEntity.status(HttpStatus.OK).body(updated))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
