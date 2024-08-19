package dev.fakestore.service;

import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.UserAuth;

/**
 * <p>Interface containing the authentication methods</p>
 *
 * @author Misael Landero
 */
public interface IAuthService {
    /**
     * <p>Authentication method, takes username and returns jwt</p>
     *
     * @param userAuth username
     * @return Object jwt
     */
    AuthToken auth(UserAuth userAuth);
}
