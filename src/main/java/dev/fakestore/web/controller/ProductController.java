package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.service.IProductService;
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
 * This controller manages all the product methods
 *
 * @author Misael Landero
 */
@Slf4j
@RestController
@RequestMapping(ProductController.API_RC_PRODUCT)
@Tag(name = "Product Controller", description = "Product CRUD")
@RequiredArgsConstructor
public class ProductController {

    static final String API_RC_PRODUCT = Constants.BASE_API_URL + Constants.PRODUCT;

    private final IProductService productService;

    /**
     * <p>
     *     Get carts will retrieve all the products if no filters are given. The available filters are:
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
    ResponseEntity<List<ProductResponse>> getProducts(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort
    ){
        log.info("API: '{}', Method 'getProducts'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllProducts(n,sort));
    }

    /**
     * <p>
     *     This method returns a product given its id
     * </p>
     * @param id ID
     * @return Cart Response
     */
    @GetMapping("/{id}")
    @Operation(summary = "GET a specific product by its id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> getProductById(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getProductById'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    /**
     * <p>
     *     This method returns all the available categories
     * </p>
     * @return List of Strings
     */
    @GetMapping("/categories")
    @Operation(summary = "GET all categories")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<String>> getCategories(){
        log.info("API: '{}', Method 'getCategories'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllCategories());
    }

    /**
     * <p>
     *     This method returns all the products associated to on category
     * </p>
     * @param category Category
     * @return List of Products
     */
    @GetMapping("/category/{category}")
    @Operation(summary = "GET all products for a category")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<ProductResponse>> getProductsInCategory(
            @PathVariable(name = "category") String category
    ){
        log.info("API: '{}', Method 'getProductsInCategory'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllProductsInCategory(category));
    }

    /**
     * <p>
     *     This method creates a new product
     * </p>
     * @param product Product
     * @return Product Response
     */
    @PostMapping
    @Operation(summary = "Create a new product")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> addProduct(
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.createProduct(product));
    }

    /**
     * <p>
     *     This method updates a product
     * </p>
     * @param id ID
     * @param product Product
     * @return Product Response
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a product")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'updateProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    /**
     * <p>
     *     This method patches a product
     * </p>
     * @param id ID
     * @param product Product
     * @return Product Response
     */
    @PatchMapping("/{id}")
    @Operation(summary = "Patch a product")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'patchProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.patchProduct(id, product));
    }

    /**
     * <p>
     *     This method deletes a product
     * </p>
     * @param id ID
     * @return Product Response
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delte a product")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'deleteProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
