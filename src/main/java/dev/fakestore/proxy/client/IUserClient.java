package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;

import java.util.ArrayList;

public interface IUserClient {
    ArrayList<UserResponse> getAllUsers(Integer n, Sort sort);
    UserResponse createUser(UserDetails user);
    UserResponse updateUser(Integer id, UserDetails user);
    UserResponse patchUser(Integer id, UserDetails user);
    UserResponse deleteUser(Integer id);
}
