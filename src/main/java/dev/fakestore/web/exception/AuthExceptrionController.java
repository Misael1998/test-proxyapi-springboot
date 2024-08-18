package dev.fakestore.web.exception;

import dev.fakestore.web.controller.AuthController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = AuthController.class)
public class AuthExceptrionController {
}
