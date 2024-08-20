package dev.fakestore.service;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;

import java.util.List;

public interface IUserService {
    List<UserResponse> getAllUsers(Integer n, Sort sort);
    UserResponse createUser(UserDetails user);
    UserResponse updateUser(Integer id, UserDetails user);
    UserResponse pathcUser(Integer id, UserDetails user);
    UserResponse deleteUser(Integer id);
    UserResponse getUserById(Integer id);
}
