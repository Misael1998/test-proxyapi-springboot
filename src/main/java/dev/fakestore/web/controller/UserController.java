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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(UserController.API_RC_USER)
@Tag(name = "User Controller", description = "User CRUD")
@RequiredArgsConstructor
public class UserController {

    static final String API_RC_USER = Constants.BASE_API_URL + Constants.USER;

    private final IUserService userService;

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

    @GetMapping("/{id}")
    @Operation(summary = "GET a specific user by its id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> getUserById(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getUserById'", API_RC_USER);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<UserResponse> createUser(@RequestBody UserDetails createUserRequest){
        log.info("API: '{}', Method 'createUser'", API_RC_USER);
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

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
