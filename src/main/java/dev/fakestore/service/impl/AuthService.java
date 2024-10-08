package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.UserAuth;
import dev.fakestore.proxy.client.IAuthClient;
import dev.fakestore.service.IAuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * AuthService Implementation
 */
@Slf4j
@Service
@SecurityRequirement(name = "javainuseapi")
@RequiredArgsConstructor
public class AuthService  implements IAuthService {

    private final IAuthClient authClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthToken auth(UserAuth userAuth) {
        log.info("[AuthService][auth] User: " + userAuth.getUsername());
        return authClient.authUser(userAuth);
    }
}
