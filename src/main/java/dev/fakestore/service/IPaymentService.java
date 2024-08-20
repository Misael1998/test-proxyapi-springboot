package dev.fakestore.service;

import dev.fakestore.domain.request.PaymentRequest;
import dev.fakestore.persistance.entity.OrderDetails;
import dev.fakestore.persistance.entity.Payments;

import java.util.List;

public interface IPaymentService {
    OrderDetails createPayment(PaymentRequest cartId);
    OrderDetails getPaymentById(Integer paymentId);
    List<Payments> getAllPayments();
}
