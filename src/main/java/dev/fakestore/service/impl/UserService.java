package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.proxy.client.IUserClient;
import dev.fakestore.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserClient userClient;

    @Override
    public ArrayList<UserResponse> getAllUsers(Integer n, Sort sort) {
        return userClient.getAllUsers(n, sort);
    }

    @Override
    public UserResponse createUser(UserDetails user) {
        return userClient.createUser(user);
    }

    @Override
    public UserResponse updateUser(Integer id, UserDetails user) {
        return userClient.updateUser(id, user);
    }

    @Override
    public UserResponse pathcUser(Integer id, UserDetails user) {
        return userClient.patchUser(id, user);
    }

    @Override
    public UserResponse deleteUser(Integer id) {
        return userClient.deleteUser(id);
    }
}
