package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.service.ICartService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping(CartController.API_RC_CART)
@RequiredArgsConstructor
public class CartController {
    static final String API_RC_CART = Constants.BASE_API_URL + Constants.CART;

    private final ICartService cartService;

    @GetMapping
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

    @GetMapping("/user/{id}")
    ResponseEntity<ArrayList<CartResponse>> getUserCarts(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getUserCarts'", API_RC_CART);
        return ResponseEntity.ok(cartService.getAllUserCarts(id));
    }

    @PostMapping
    ResponseEntity<CartResponse> addProduct(
            @RequestBody Cart product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.createProduct(product));
    }

    @PutMapping("/{id}")
    ResponseEntity<CartResponse> updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    ){
        log.info("API: '{}', Method 'updateProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.updateProduct(id, cart));
    }

    @PatchMapping("/{id}")
    ResponseEntity<CartResponse> patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    ){
        log.info("API: '{}', Method 'patchProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.patchProduct(id, cart));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CartResponse> deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'deleteProduct'", API_RC_CART);
        return ResponseEntity.ok(cartService.deleteProduct(id));
    }
}
