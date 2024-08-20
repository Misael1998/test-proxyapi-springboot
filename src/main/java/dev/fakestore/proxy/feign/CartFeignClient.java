package dev.fakestore.proxy.feign;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.response.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * FeingClient interface for the cart methods
 *
 * @author Misael Landero
 */
@Component
@FeignClient(value = "CartFeignClient", name = "CartFeignClient",url = Constants.FAKESOTRE_API_URL)
public interface CartFeignClient {
    /**
     * <p>Get all carts method</p>
     *
     * @return ProductResponse list
     */
    @GetMapping(
            value = "/carts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<CartResponse> getAllCarts(
            @RequestParam(name = "limit", required = false) Integer n,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "startdate", required = false) Date startdate,
            @RequestParam(name = "enddate", required = false) Date enddate

    );

    /**
     * <p>Get all carts associated to one user</p>
     *
     * @return ProductResponse list
     */
    @GetMapping(
            value = "/carts/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<CartResponse> getAllUserCarts(
            @PathVariable(name = "id") Integer integer
    );

    /**
     * <p>Create a new cart</p>
     *
     * @return CartResponse
     */
    @PostMapping(
            value = "/carts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CartResponse createProduct(
            @RequestBody Cart cart
    );

    /**
     * <p>Update a cart</p>
     *
     * @return CartResponse
     */
    @PutMapping(
            value = "/carts/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CartResponse updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    );

    /**
     * <p>Patch a cart</p>
     *
     * @return CartResponse
     */
    @PatchMapping(
            value = "/carts/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CartResponse patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Cart cart
    );

    /**
     * <p>Create a new cart</p>
     *
     * @return CartResponse
     */
    @DeleteMapping(
            value = "/carts/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CartResponse deleteProduct(
            @PathVariable(name = "id") Integer id
    );

    @GetMapping(
            value = "/cart/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CartResponse getCartById(
            @PathVariable(name = "id") Integer id
    );
}
