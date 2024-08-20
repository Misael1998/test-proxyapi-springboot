package dev.fakestore.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order_details")
    private Integer id;

    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false, updatable = false)
    private Orders orders;

    @OneToMany(mappedBy = "orderDetails", fetch = FetchType.EAGER)
    private List<Products> products;
}
