package dev.fakestore.service;

import dev.fakestore.domain.request.PaymentRequest;

public interface IPaymentService {
    Object createPayment(PaymentRequest cartId);
    Object getPaymentById(Integer paymentId);
    Object getAllPayments();
}
