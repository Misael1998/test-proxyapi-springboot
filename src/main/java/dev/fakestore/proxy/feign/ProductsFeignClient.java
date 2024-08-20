package dev.fakestore.proxy.feign;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * FeingClient interface for the product methods
 *
 * @author Misael Landero
 */
@Component
@FeignClient(value = "ProductsFeignClient", name = "ProductsFeignClient",url = Constants.FAKESOTRE_API_URL)
public interface ProductsFeignClient {

    /**
    * <p>Get all products method</p>
     *
     * @return ProductResponse list
     */
    @GetMapping(
            value = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<ProductResponse> getAllUsers(
            @RequestParam(name = "limit", required = false) Integer n,
            @RequestParam(name = "sort", required = false) String sort
    );

    /**
     * <p>Get all categories method</p>
     *
     * @return String list
     */
    @GetMapping(
            value = "/products/categories",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<String> getAllCategories();

    /**
     * <p>Get all products in category method</p>
     *
     * @return String list
     */
    @GetMapping(
            value = "/products/category/{category}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ArrayList<String> getAllProductsInCategory(
            @PathVariable(name = "category") String category
    );

    /**
     * <p>Create a new product</p>
     *
     * @return ProductResponse
     */
    @PostMapping(
            value = "/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ProductResponse createProduct(
            @RequestBody Product user
    );

    /**
     * <p>Update a product</p>
     *
     * @return ProductResponse
     */
    @PutMapping(
            value = "/products/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ProductResponse updateProduct(
            @PathVariable(name = "id") String id,
            @RequestBody Product user
    );

    /**
     * <p>Patch a product</p>
     *
     * @return ProductResponse
     */
    @PatchMapping(
            value = "/products/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ProductResponse pathProduct(
            @PathVariable(name = "id") String id,
            @RequestBody Product user
    );

    /**
     * <p>Create a new product</p>
     *
     * @return ProductResponse
     */
    @DeleteMapping(
            value = "/products/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ProductResponse deleteProduct(
            @PathVariable(name = "id") String id
    );
}
