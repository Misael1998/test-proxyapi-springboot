package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.User;
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
    public AuthToken authUser(User user) {
        log.info("[AuthClient][authUser] Usuario: " + user.getUsername());
        return authFeignClient.authUser(user);
    }
}
