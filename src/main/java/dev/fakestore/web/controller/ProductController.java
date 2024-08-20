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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(ProductController.API_RC_PRODUCT)
@Tag(name = "Product Controller", description = "Product CRUD")
@RequiredArgsConstructor
public class ProductController {

    static final String API_RC_PRODUCT = Constants.BASE_API_URL + Constants.PRODUCT;

    private final IProductService productService;

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

    @GetMapping("/{id}")
    @Operation(summary = "GET a specific product by its id")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> getProductById(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'getProductById'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/categories")
    @Operation(summary = "GET all categories")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<String>> getCategories(){
        log.info("API: '{}', Method 'getCategories'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllCategories());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "GET all products for a category")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<List<ProductResponse>> getProductsInCategory(
            @PathVariable(name = "category") String category
    ){
        log.info("API: '{}', Method 'getProductsInCategory'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllProductsInCategory(category));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    @SecurityRequirement(name = "Authorization Bearer")
    ResponseEntity<ProductResponse> addProduct(
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.createProduct(product));
    }

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
