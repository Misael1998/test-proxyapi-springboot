package dev.fakestore.persistance.repository;

import dev.fakestore.persistance.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}
