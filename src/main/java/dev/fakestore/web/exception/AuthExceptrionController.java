package dev.fakestore.web.exception;

import dev.fakestore.web.controller.AuthController;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Exception Controller
 * This controller manages all exception generated in AuthController
 */
@ControllerAdvice(assignableTypes = AuthController.class)
public class AuthExceptrionController {
}
