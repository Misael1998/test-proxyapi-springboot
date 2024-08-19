package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.proxy.feign.UserFeignClient;
import dev.fakestore.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserFeignClient userFeignClient;

    @Override
    public ArrayList<UserResponse> getAllUsers(Integer n, Sort sort) {
        return userFeignClient.getAllUsers(n, sort.getSort());
    }

    @Override
    public UserResponse createUser(UserDetails user) {
        return userFeignClient.createUser(user);
    }

    @Override
    public UserResponse updateUser(Integer id, UserDetails user) {
        return userFeignClient.updateUser(id, user);
    }

    @Override
    public UserResponse pathcUser(Integer id, UserDetails user) {
        return userFeignClient.patchUser(id, user);
    }

    @Override
    public UserResponse deleteUser(Integer id) {
        return userFeignClient.deleteUser(id);
    }
}
