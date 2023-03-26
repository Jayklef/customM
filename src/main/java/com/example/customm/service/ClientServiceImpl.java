package com.example.customm.service;

import com.example.customm.dto.ClientDto;
import com.example.customm.entity.Client;
import com.example.customm.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(ClientDto clientDto) {

        Client newClient = new Client();
        newClient.setFirstname(clientDto.getFirstname());
        newClient.setLastname(clientDto.getLastname());
        newClient.setEmail(clientDto.getEmail());
        newClient.setBirthDate(clientDto.getBirthDate());
        newClient.setAddress(clientDto.getAddress());
        newClient.setNin(clientDto.getNin());
        newClient.setBvn(clientDto.getBvn());

        return clientRepository.save(newClient);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClient(Long id) {

        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public Client updateClient(Long id, ClientDto clientDto) {

        Client clientInDb = clientRepository.findById(id).get();
        if (Objects.nonNull(clientInDb.getFirstname()) &&
        !"".equalsIgnoreCase(clientDto.getFirstname())){
            clientInDb.setFirstname(clientDto.getFirstname());
        }

        if (Objects.nonNull(clientDto.getLastname()) &&
        !"".equalsIgnoreCase(clientDto.getLastname())){
            clientInDb.setLastname(clientDto.getLastname());
        }

        if (Objects.nonNull(clientDto.getEmail()) &&
        !"".equalsIgnoreCase(clientDto.getEmail())){
            clientInDb.setEmail(clientDto.getEmail());
        }

        if (Objects.nonNull(clientDto.getBirthDate()) &&
        !"".equalsIgnoreCase(clientDto.getBirthDate().toString())){
            clientInDb.setBirthDate(clientDto.getBirthDate());
        }

        if (Objects.nonNull(clientDto.getAddress())&&
        !"".equalsIgnoreCase(clientDto.getAddress())){
            clientInDb.setAddress(clientDto.getAddress());
        }

        if (Objects.nonNull(clientDto.getNin()) &&
        !"".equalsIgnoreCase(clientDto.getNin())){
            clientInDb.setNin(clientDto.getNin());
        }

        if (Objects.nonNull(clientDto.getBvn()) &&
        !"".equalsIgnoreCase(clientDto.getBvn())){
            clientInDb.setBvn(clientDto.getBvn());
        }

        return clientRepository.save(clientInDb);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = findClient(id);
        clientRepository.deleteById(client.getId());
    }
}
