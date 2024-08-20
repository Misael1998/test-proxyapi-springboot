package dev.fakestore.service;

import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;

import java.util.List;

/**
 * Interface containing the payment methods
 *
 * @author Misael Landero
 */
public interface IUserService {
    /**
     * <p>
     *     This method gets all users, filtered and unfiltered
     * </p>
     * @param n N
     * @param sort Sort
     * @return List of User Response
     */
    List<UserResponse> getAllUsers(Integer n, Sort sort);

    /**
     * <p>
     *     This method creates a new user
     * </p>
     * @param user User
     * @return User Response
     */
    UserResponse createUser(UserDetails user);

    /**
     * <p>
     *     This method updates a user
     * </p>
     * @param id ID
     * @param user User
     * @return User Respponse
     */
    UserResponse updateUser(Integer id, UserDetails user);

    /**
     * <p>
     *     This method patches a user
     * </p>
     * @param id ID
     * @param user User
     * @return User Respponse
     */
    UserResponse pathcUser(Integer id, UserDetails user);

    /**
     * <p>
     *     This method deletes a user
     * </p>
     * @param id ID
     * @return User Response
     */
    UserResponse deleteUser(Integer id);

    /**
     * <p>
     *     This method gets a user by its id
     * </p>
     * @param id  ID
     * @return User Response
     */
    UserResponse getUserById(Integer id);
}
