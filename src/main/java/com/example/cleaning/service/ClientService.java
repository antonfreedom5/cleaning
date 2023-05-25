package com.example.cleaning.service;

import com.example.cleaning.entity.Client;
import com.example.cleaning.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final OrderService orderService;

    public ClientService(ClientRepository clientRepository, OrderService orderService) {
        this.clientRepository = clientRepository;
        this.orderService = orderService;
    }

    public void create(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.orderService.getByClientId(id).ifPresentOrElse(
            order -> System.out.printf("Client %s has an order and can not be deleted!", order.getClient().getFirstName()),
            () -> clientRepository.deleteById(id)
        );
    }
}
