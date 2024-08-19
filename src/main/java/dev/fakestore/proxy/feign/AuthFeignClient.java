package dev.fakestore.proxy.feign;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.AuthToken;
import dev.fakestore.domain.dto.UserAuth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * FeingClient interface for the authentication methods
 *
 * @author Misael Landero
 */
@Component
@FeignClient(value = "AuthFeignClient", name = "AuthFeignClient",url = Constants.FAKESOTRE_API_URL)
public interface AuthFeignClient {

    /**
     * <p>Auth user method that calls the auth endpoint of FakeSotreApi</p>
     *
     * @param userAuth User object containing username and password
     * @return AuthToken
     */
    @PostMapping(
            value = "/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    AuthToken authUser(@RequestBody UserAuth userAuth);

}
