package dev.fakestore.proxy.feign;


import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * FeingClient interface for the user methods
 *
 * @author Misael Landero
 */
@Component
@FeignClient(value = "UserFeignClient", name = "UserFeignClient",url = Constants.FAKESOTRE_API_URL)
public interface UserFeignClient {

    /**
     * <p>Get all users method</p>
     *
     * @return UserResponse list
     */
    @GetMapping(
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<UserResponse> getAllUsers(
            @RequestParam(name = "limit", required = false) Integer n,
            @RequestParam(name = "sort", required = false) String sort
    );

    /**
     * <p>Create a new user</p>
     *
     * @return UserResponse
     */
    @PostMapping(
            value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserResponse createUser(
            @RequestBody UserDetails user
    );

    @PutMapping(
            value = "/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserResponse updateUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails user
    );

    @PatchMapping(
            value = "/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserResponse patchUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails user
    );

    @DeleteMapping(
            value = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserResponse deleteUser(
            @PathVariable(name = "id") Integer id
    );
}
