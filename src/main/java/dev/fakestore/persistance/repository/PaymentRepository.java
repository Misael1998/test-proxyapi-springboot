package dev.fakestore.persistance.repository;


import dev.fakestore.persistance.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, Integer> {
}
