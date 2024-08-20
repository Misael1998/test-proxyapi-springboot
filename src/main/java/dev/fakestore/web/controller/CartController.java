package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.service.ICartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping(CartController.API_RC_CART)
@Tag(name = "Cart Controller", description = "Cart CRUD")
@RequiredArgsConstructor
public class CartController {
    static final String API_RC_CART = Constants.BASE_API_URL + Constants.CART;

    private final ICartService cartService;

    @GetMapping
    @Operation(summary = "GET all carts, limit carts, sorted carts and date interval")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ArrayList<CartResponse>> getCarts(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort,
            @Parameter(name = "startdate")
            @RequestParam(name = "startdate", required = false) Date startdate,
            @Parameter(name = "enddate")
            @RequestParam(name = "enddate", required = false) Date enddate
    ){
        log.info("API: '{}', Method 'getCarts'", API_RC_CART);
        return ResponseEntity.ok(cartService.getAllCarts(n,sort,startdate,enddate));
    }

    @GetMapping("/{id}")
    @Operation(summary = "GET a specific cart by its id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<CartResponse> getCartById(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getCartById'", API_RC_CART);
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "GET a specific cart for a user")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ArrayList<CartResponse>> getUserCarts(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getUserCarts'", API_RC_CART);
        return ResponseEntity.ok(cartService.getAllUserCarts(id));
    }

    @PostMapping
    @Operation(summary = "Create a cart")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<CartResponse> addProduct(
            @RequestBody Cart product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.createProduct(product));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a cart")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<CartResponse> updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    ){
        log.info("API: '{}', Method 'updateProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.updateProduct(id, cart));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Patch a cart")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<CartResponse> patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    ){
        log.info("API: '{}', Method 'patchProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.patchProduct(id, cart));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cart")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<CartResponse> deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'deleteProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.deleteProduct(id));
    }
}
