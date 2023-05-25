package com.example.cleaning.repository;

import com.example.cleaning.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByClientId(Long id);
    Optional<Order> findByStatusId(Long id);
    Optional<Order> findByDriverId(Long id);
}
