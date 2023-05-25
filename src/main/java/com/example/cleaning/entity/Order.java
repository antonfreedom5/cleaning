package com.example.cleaning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "client_order")

public class Order {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @OneToOne
    private Client client;
    @OneToOne
    private Driver driver;
    @OneToOne
    private Status status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
            "id=" + id +
            ", client=" + client +
            ", driver=" + driver +
            ", status=" + status +
            '}';
    }
}
