package dev.fakestore.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_payment")
    private Integer id;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToOne
    @JsonIgnore
    @JoinColumn(referencedColumnName = "id_order")
    private Orders orders;
}
