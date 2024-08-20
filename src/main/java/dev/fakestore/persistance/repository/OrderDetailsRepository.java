package dev.fakestore.persistance.repository;

import dev.fakestore.persistance.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> getOrderDetailsByCartId(Integer cartId);

}
