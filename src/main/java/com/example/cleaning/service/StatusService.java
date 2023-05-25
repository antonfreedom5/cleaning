package com.example.cleaning.service;

import com.example.cleaning.entity.Status;
import com.example.cleaning.repository.StatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final OrderService orderService;

    public StatusService(StatusRepository statusRepository, OrderService orderService) {
        this.statusRepository = statusRepository;
        this.orderService = orderService;
    }

    public void create(Status status) {
        statusRepository.save(status);
    }

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Optional<Status> getById(Long id) {
        return statusRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.orderService.getByStatusId(id).ifPresentOrElse(
            order -> System.out.printf("Status %s has an order and can not be deleted!", order.getStatus().getName()),
            () -> statusRepository.deleteById(id)
        );
    }
}
