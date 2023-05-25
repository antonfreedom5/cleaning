package com.example.cleaning.service;

import com.example.cleaning.entity.Driver;
import com.example.cleaning.repository.DriverRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final OrderService orderService;

    public DriverService(DriverRepository driverRepository, OrderService orderService) {
        this.driverRepository = driverRepository;
        this.orderService = orderService;
    }

    public void create(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getById(Long id) {
        return driverRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.orderService.getByDriverId(id).ifPresentOrElse(
            order -> System.out.printf("Driver %s has an order and can not be deleted!", order.getDriver().getFirstName()),
            () -> driverRepository.deleteById(id)
        );
    }
}
