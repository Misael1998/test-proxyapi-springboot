package dev.fakestore.service.impl;

import dev.fakestore.domain.exception.PaymentNotFoundException;
import dev.fakestore.domain.request.PaymentRequest;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.persistance.entity.*;
import dev.fakestore.persistance.repository.*;
import dev.fakestore.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Payment Service Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;
    private final PaymentRepository paymentRepository;
    private final CustomerRepositoy customerRepositoy;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderDetails createPayment(PaymentRequest paymentRequest) {
        CartResponse cart = cartService.getCartById(paymentRequest.getCartId());
        UserResponse user = userService.getUserById(cart.getUserId());
        List<Products> items = cart.getProducts().stream().map(cartProduct -> {
            Products productItem = new Products();
            ProductResponse product = productService.getProductById(cartProduct.getProductId());
            productItem.setQuantity(cartProduct.getQuantity());
            productItem.setName(product.getTitle());
            productItem.setPrice(product.getPrice());
            return productItem;
        }).toList();

        Customers customer = new Customers();
        customer.setId(user.getId());
        customer.setName(user.getName().getFirstname());
        customer = customerRepositoy.save(customer);

        Payments payment = new Payments();
        payment.setPaymentType(paymentRequest.getPaymentType());
        payment = paymentRepository.save(payment);

        Orders order = new Orders();
        order.setPayment(payment);
        order.setCustomer(customer);
        order = orderRepository.save(order);

        items = productRepository.saveAll(items);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProducts(items);
        orderDetails.setOrders(order);
        orderDetails.setCartId(cart.getId());

        float total = 0;
        for(Products item: items){
            total = total + item.getQuantity() * item.getPrice();
        }

        orderDetails.setTotal(total);

        orderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderDetails getPaymentById(Integer paymentId) {
        return orderDetailsRepository
                .findAllByPaymentId(paymentId)
                .orElseThrow(PaymentNotFoundException::new);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payments> getAllPayments() {
        return paymentRepository.findAll();
    }
}
