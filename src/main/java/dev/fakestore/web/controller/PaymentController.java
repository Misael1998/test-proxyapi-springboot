package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.request.PaymentRequest;
import dev.fakestore.persistance.entity.OrderDetails;
import dev.fakestore.persistance.entity.Payments;
import dev.fakestore.service.IPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller manages all the payment methods
 *
 * @author Misael Landero
 */
@Slf4j
@RestController
@RequestMapping(PaymentController.API_RC_PAYMENT)
@Tag(name = "Payment Controller", description = "Payments requests")
@RequiredArgsConstructor
public class PaymentController {
    static final String API_RC_PAYMENT = Constants.BASE_API_URL + Constants.PAYMENT;

    private final IPaymentService paymentService;

    /**
     * <p>
     *     This method creates a new payment from an existing cartId stored in the Fake API
     * </p>
     * @param paymentRequest Payment Request
     * @return  Order Details
     */
    @PostMapping
    @Operation(summary = "Create a new payment")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<OrderDetails> createPaymentRequest(PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }

    /**
     * <p>
     *     This method returns the Order Details from a payment by its id
     * </p>
     * @param id ID
     * @return Order Details
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get payment by id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<OrderDetails> getPaymentById(
            @PathVariable(name = "id") Integer id
    ){
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    /**
     * <p>
     *     This method returns all the saved payments
     * </p>
     * @return List of Payments
     */
    @GetMapping
    @Operation(summary = "Get all payments")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<Payments>> getPaymentById(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}
