package dev.fakestore.web.controller;

import dev.fakestore.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping
    public ResponseEntity<String> authUser(@RequestBody  String username){
        return ResponseEntity.ok(this.authService.auth(username));
    }

}
