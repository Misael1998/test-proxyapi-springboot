package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.UserDetails;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.service.IUserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(UserController.API_RC_USER)
@RequiredArgsConstructor
public class UserController {

    static final String API_RC_USER = Constants.BASE_API_URL + Constants.USER;

    private final IUserService userService;

    @GetMapping
    ResponseEntity<Object> getUsers(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort
    ){
        log.info("API: '{}', Method 'getAllUsers'", API_RC_USER);
        return ResponseEntity.ok(userService.getAllUsers(n,sort));
    }

    @PostMapping
    ResponseEntity<Object> createUser(@RequestBody UserDetails createUserRequest){
        log.info("API: '{}', Method 'createUser'", API_RC_USER);
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails updateUserRequest
    ){
        log.info("API: '{}', Method 'updateUser'", API_RC_USER);
        return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }

    @PatchMapping("/{id}")
    ResponseEntity<Object> patchUser(
            @PathVariable(name = "id") Integer id,
            @RequestBody UserDetails patchUserRequest
    ){
        log.info("API: '{}', Method 'patchUser'", API_RC_USER);
        return ResponseEntity.ok(userService.pathcUser(id, patchUserRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deteleUser(
            @Parameter(name = "id", example = "6")
            @PathVariable Integer id
    ){
        log.info("API: '{}', Method 'deleteUser'", API_RC_USER);
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
