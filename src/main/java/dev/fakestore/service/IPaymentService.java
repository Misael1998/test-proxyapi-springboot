package dev.fakestore.service;

import dev.fakestore.domain.request.PaymentRequest;
import dev.fakestore.persistance.entity.OrderDetails;
import dev.fakestore.persistance.entity.Payments;

import java.util.List;

/**
 * Interface containing the payment methods
 *
 * @author Misael Landero
 */
public interface IPaymentService {
    /**
     * <p>
     *     This method creates a new payment, populating the DB tables by getting the data from the Fake API
     * </p>
     * @param cartId Cart ID
     * @return Order Details
     */
    OrderDetails createPayment(PaymentRequest cartId);

    /**
     * <p>
     *     This method returns the order details saved to the DB by it payment id
     * </p>
     * @param paymentId Payment ID
     * @return Order Details
     */
    OrderDetails getPaymentById(Integer paymentId);

    /**
     * <p>
     *     This method obtains all the payments saved to the DB
     * </p>
     * @return Payments
     */
    List<Payments> getAllPayments();
}
