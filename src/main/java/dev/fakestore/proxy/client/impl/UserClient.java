package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.proxy.client.IUserClient;
import dev.fakestore.proxy.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserClient implements IUserClient {

    private final UserFeignClient userFeignClient;

    @Override
    public List<UserResponse> getAllUsers(Integer n, Sort sort) {
        log.info("[UserClient][getAllUsers]: " +
                ((n == null) && (sort == null) ? "Filter -> ":"") +
                (sort == null ? "":"Sort order: "+sort.getSort()) +
                (n == null ? "":"Products to be retrieve: "+n));
        return userFeignClient.getAllUsers(n, sort == null ? null : sort.getSort());
    }

    @Override
    public UserResponse createUser(UserDetails user) {
        log.info("[UserClient][createUser] User: " + user);
        return userFeignClient.createUser(user);
    }

    @Override
    public UserResponse updateUser(Integer id, UserDetails user) {
        log.info("[UserClient][updateUser] UserID: " + id + " User: " + user);
        return userFeignClient.updateUser(id, user);
    }

    @Override
    public UserResponse patchUser(Integer id, UserDetails user) {
        log.info("[UserClient][patchUser] UserID: " + id + " User: " + user);
        return userFeignClient.patchUser(id, user);
    }

    @Override
    public UserResponse deleteUser(Integer id) {
        log.info("[UserClient][deleteUser] "+"UserId: " + id);
        return userFeignClient.deleteUser(id);
    }

    @Override
    public UserResponse getUserById(Integer id) {
        log.info("[UserClient][getUserById] "+"UserId: " + id);
        return userFeignClient.getUserById(id);
    }
}
