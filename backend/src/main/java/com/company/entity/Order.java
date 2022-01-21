package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @OneToOne
    private Client client;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private String description;

    public Order(Client client, LocalDateTime deliveryDate, LocalDateTime orderDate, String description) {
        this.client = client;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.description = description;

    }
}
