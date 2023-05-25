package com.example.cleaning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
