package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.request.PaymentRequest;
import dev.fakestore.service.IPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(PaymentController.API_RC_PAYMENT)
@Tag(name = "Payment Controller", description = "Payments requests")
@RequiredArgsConstructor
public class PaymentController {
    static final String API_RC_PAYMENT = Constants.BASE_API_URL + Constants.PAYMENT;

    private final IPaymentService paymentService;

    @PostMapping
    @Operation(summary = "Create a new payment")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<Object> createPaymentRequest(PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }
}
