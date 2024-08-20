package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.enumeration.Sort;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(CartController.API_RC_CART)
@RequiredArgsConstructor
public class CartController {
    static final String API_RC_CART = Constants.BASE_API_URL + Constants.CART;

    @GetMapping
    ResponseEntity<Object> getCarts(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort
    ){
        log.info("API: '{}', Method 'getCarts'", API_RC_CART);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/user/{id}")
    ResponseEntity<Object> getUserCarts(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getUserCarts'", API_RC_CART);
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<Object> addProduct(
            @RequestBody Object product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_CART);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Object product
    ){
        log.info("API: '{}', Method 'updateProduct'", API_RC_CART);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Object> patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Object product
    ){
        log.info("API: '{}', Method 'patchProduct'", API_RC_CART);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'deleteProduct'", API_RC_CART);
        return ResponseEntity.ok(null);
    }
}
