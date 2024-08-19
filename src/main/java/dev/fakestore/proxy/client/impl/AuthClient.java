package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.UserAuth;
import dev.fakestore.proxy.client.IAuthClient;
import dev.fakestore.proxy.feign.AuthFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * AuthClient Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthClient implements IAuthClient {

    private final AuthFeignClient authFeignClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthToken authUser(UserAuth userAuth) {
        log.info("[AuthClient][authUser] Usuario: " + userAuth.getUsername());
        return authFeignClient.authUser(userAuth);
    }
}
