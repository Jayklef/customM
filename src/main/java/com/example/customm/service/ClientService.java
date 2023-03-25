package com.example.customm.service;

import com.example.customm.dto.ClientDto;
import com.example.customm.entity.Client;

import java.util.List;

public interface ClientService {

    Client saveClient(ClientDto clientDto);

    List<Client> findAllClients();

    Client findClient(Long id);

    Client updateClient(Long id, ClientDto clientDto);

    void deleteClient(Long id);
}
