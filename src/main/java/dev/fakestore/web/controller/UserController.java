package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.UserResponse;
import dev.fakestore.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller manages all the cart methods
 *
 * @author Misael Landero
 */
@Slf4j
@RestController
@RequestMapping(UserController.API_RC_USER)
@Tag(name = "User Controller", description = "User CRUD")
@RequiredArgsConstructor
public class UserController {

    static final String API_RC_USER = Constants.BASE_API_URL + Constants.USER;

    private final IUserService userService;

    /**
     * <p>
     *     Get carts will retrieve all the users if no filters are given. The available filters are:
     *     <ul>
     *         <li>N - number of elements to be returned</li>
     *         <li>Sort - asc or desc sor</li>
     *     </ul>
     * </p>
     * @param n N
     * @param sort Sort
     * @return List of CartResponse
     */
    @GetMapping
    @Operation(summary = "GET all users, limit users and sorted users")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<UserResponse>> getUsers(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort
    ){
        log.info("API: '{}', Method 'getAllUsers'", API_RC_USER);
        return ResponseEntity.ok(userService.getAllUsers(n,sort));
    }

    /**
     * <p>
     *     This method returns a user given its id
     * </p>
     * @param id ID
     * @return User Response
     */
    @GetMapping("/{id}")
    @Operation(summary = "GET a specific user by its id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> getUserById(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getUserById'", API_RC_USER);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * <p>
     *     This method creates a new user
     * </p>
     * @param createUserRequest User Details
     * @return User Response
     */
    @PostMapping
    @Operation(summary = "Create a new user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> createUser(@RequestBody UserDetails createUserRequest){
        log.info("API: '{}', Method 'createUser'", API_RC_USER);
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    /**
     * <p>
     *     This method updates a user
     * </p>
     * @param id ID
     * @param updateUserRequest User Details
     * @return User Response
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> updateUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails updateUserRequest
    ){
        log.info("API: '{}', Method 'updateUser'", API_RC_USER);
        return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }

    /**
     * <p>
     *     This method patches a user
     * </p>
     * @param id ID
     * @param patchUserRequest User Details
     * @return User Response
     */
    @PatchMapping("/{id}")
    @Operation(summary = "Patch a user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> patchUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails patchUserRequest
    ){
        log.info("API: '{}', Method 'patchUser'", API_RC_USER);
        return ResponseEntity.ok(userService.pathcUser(id, patchUserRequest));
    }

    /**
     * <p>
     *     This method deletes a user
     * </p>
     * @param id ID
     * @return User Response
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> deleteUser(
            @Parameter(name = "id", example = "6")
            @PathVariable Integer id
    ){
        log.info("API: '{}', Method 'deleteUser'", API_RC_USER);
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
