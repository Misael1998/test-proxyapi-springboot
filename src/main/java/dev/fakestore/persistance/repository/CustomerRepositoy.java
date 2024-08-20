package dev.fakestore.persistance.repository;

import dev.fakestore.persistance.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoy extends JpaRepository<Customers, Integer> {
}
