package dev.fakestore.web.controller;

import dev.fakestore.domain.common.Constants;
import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.service.IProductService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping(ProductController.API_RC_PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    static final String API_RC_PRODUCT = Constants.BASE_API_URL + Constants.PRODUCT;

    private final IProductService productService;

    @GetMapping
    ResponseEntity<ArrayList<ProductResponse>> getProducts(
            @Parameter(name = "limit", example = "1")
            @RequestParam(name = "limit", required = false) Integer n,
            @Parameter(name = "sort")
            @RequestParam(name = "sort", required = false) Sort sort
    ){
        log.info("API: '{}', Method 'getProducts'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllProducts(n,sort));
    }

    @GetMapping("/categories")
    ResponseEntity<ArrayList<String>> getCategories(){
        log.info("API: '{}', Method 'getCategories'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllCategories());
    }

    @GetMapping("/categories/{category}")
    ResponseEntity<ArrayList<ProductResponse>> getProductsInCategory(
            @PathVariable(name = "category") String category
    ){
        log.info("API: '{}', Method 'getProductsInCategory'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.getAllProductsInCategory(category));
    }

    @PostMapping
    ResponseEntity<ProductResponse> addProduct(
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'addProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductResponse> updateProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'updateProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @PatchMapping("/{id}")
    ResponseEntity<ProductResponse> patchProduct(
            @PathVariable(name = "id") Integer id,
            @RequestBody Product product
    ){
        log.info("API: '{}', Method 'patchProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.patchProduct(id, product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ProductResponse> deleteProduct(
            @PathVariable(name = "id") Integer id
    ){
        log.info("API: '{}', Method 'deleteProduct'", API_RC_PRODUCT);
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
