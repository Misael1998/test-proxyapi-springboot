package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.proxy.client.IUserClient;
import dev.fakestore.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Payment Service Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserClient userClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserResponse> getAllUsers(Integer n, Sort sort) {
        log.info("[UserService][getAllUsers]: " +
                ((n == null) && (sort == null) ? "Filter -> ":"") +
                (sort == null ? "":"Sort order: "+sort.getSort()) +
                (n == null ? "":"Products to be retrieve: "+n));
        return userClient.getAllUsers(n, sort);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponse createUser(UserDetails user) {
        log.info("[UserService][createUser] User: " + user);
        return userClient.createUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponse updateUser(Integer id, UserDetails user) {
        log.info("[UserService][updateUser] UserID: " + id + " User: " + user);
        return userClient.updateUser(id, user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponse pathcUser(Integer id, UserDetails user) {
        log.info("[UserService][patchUser] UserID: " + id + " User: " + user);
        return userClient.patchUser(id, user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponse deleteUser(Integer id) {
        log.info("[UserService][deleteUser] "+"UserId: " + id);
        return userClient.deleteUser(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserResponse getUserById(Integer id) {
        log.info("[UserService][getUserById] "+"UserId: " + id);
        return userClient.getUserById(id);
    }
}
