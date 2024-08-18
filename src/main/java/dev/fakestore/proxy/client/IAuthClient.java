package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.User;

/**
 * AuthClient services interface
 *
 * @author Misael Landero
 */
public interface IAuthClient {
    /**
     * User authorization method
     * Takes user object to authenticate it and then returns a JWT
     *
     * @param user User Object containing username and password
     * @return Authorization Token
     */
    AuthToken authUser(User user);
}
