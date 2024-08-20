package dev.fakestore.persistance.repository;

import dev.fakestore.persistance.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
