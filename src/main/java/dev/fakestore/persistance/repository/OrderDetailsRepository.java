package dev.fakestore.persistance.repository;

import dev.fakestore.persistance.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    @Query("from OrderDetails od where od.orders.payment.id = :paymentId")
    Optional<OrderDetails> findAllByPaymentId(Integer paymentId);
}
