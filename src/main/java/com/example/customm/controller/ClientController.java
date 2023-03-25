package com.example.customm.controller;

import com.example.customm.dto.ClientDto;
import com.example.customm.entity.Client;
import com.example.customm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@Validated @RequestBody ClientDto clientDto){
        Client newClient = clientService.saveClient(clientDto);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id){
        Client client = clientService.findClient(id);
        return new ResponseEntity<>(client, HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,
                                               @RequestBody ClientDto clientDto){
        Client clientToUpdate = clientService.updateClient(id, clientDto);
        return new ResponseEntity<>(clientToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<ResponseStatus> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
