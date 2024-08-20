package dev.fakestore.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customers customer;

    @OneToOne
    @JoinColumn(referencedColumnName = "id_payment")
    private Payments payment;

}
