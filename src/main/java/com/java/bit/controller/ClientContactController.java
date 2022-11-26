package com.java.bit.controller;

import com.java.bit.dto.ClientContactDto;
import com.java.bit.dto.ClientContactRsDto;
import com.java.bit.service.ClientContactService;
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
@RequestMapping("client-contacts")
public class ClientContactController {

    @Autowired
    private ClientContactService clientContactService;

    @GetMapping("")
    public ResponseEntity<List<ClientContactRsDto>> getClientContacts() {
        return ResponseEntity.status(HttpStatus.OK).body(
                clientContactService.getClientContacts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientContactRsDto> getClientContact(@PathVariable("id") Long clientContactId) {
        Optional<ClientContactRsDto> clientContact = clientContactService.getClientContactById(clientContactId);

        return clientContact
                .map(clientContactDto -> ResponseEntity.status(HttpStatus.OK).body(clientContactDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Boolean> saveClientContact(@RequestBody ClientContactDto clientContactDto) {
        clientContactService.saveClientContact(clientContactDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientContactRsDto> updateClientContact(@PathVariable("id") Long clientId, @RequestBody ClientContactDto clientContactDto) {
        Optional<ClientContactRsDto> client = clientContactService.updateClientContact(clientId, clientContactDto);

        return client
                .map(updated -> ResponseEntity.status(HttpStatus.OK).body(updated))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClientContact(@PathVariable("id") Long clientContactId) {
        clientContactService.deleteClientContactById(clientContactId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
