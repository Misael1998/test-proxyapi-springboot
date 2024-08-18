package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.User;
import dev.fakestore.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(AuthController.API_RC_AUTH)
@RequiredArgsConstructor
public class AuthController {

    static final String API_RC_AUTH = Constants.BASE_API_URL + Constants.AUTH;

    private final IAuthService authService;

    /**
     * <p>This endpoint allows the user to authenticate via username and password</p>
     * @param user User object that contains username and password
     * @return AuthToken generated JWT
     */
    @PostMapping
    @Operation(summary = "Authenticates user")
    public ResponseEntity<AuthToken> authUser(@RequestBody User user){
        log.info("API: '{}/{idExploratorio}', Método 'actualizarExploratorio'", API_RC_AUTH);
        return ResponseEntity.ok(this.authService.auth(user));
    }

}
