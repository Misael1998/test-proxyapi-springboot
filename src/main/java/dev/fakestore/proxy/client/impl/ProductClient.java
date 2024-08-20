package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.proxy.client.IProductClient;
import dev.fakestore.proxy.feign.ProductsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductClient implements IProductClient {

    private final ProductsFeignClient productsFeignClient;

    @Override
    public ArrayList<ProductResponse> getAllProducts(Integer n, Sort sort) {
        log.info("[ProductClient][getAllProducts]: " +
                ((n == null) && (sort == null) ? "Filter -> ":"") +
                (sort == null ? "":"Sort order: "+sort.getSort()) +
                (n == null ? "":"Products to be retrieve: "+n));
        return productsFeignClient.getAllProducts(n, sort == null ? null : sort.getSort());
    }

    @Override
    public ArrayList<String> getAllCategories() {
        log.info("[AuthClient][getAllCategories]");
        return productsFeignClient.getAllCategories();
    }

    @Override
    public ArrayList<ProductResponse> getAllProductsInCategory(String category) {
        log.info("[AuthClient][getAllProductsInCategory] Category: " + category);
        return productsFeignClient.getAllProductsInCategory(category);
    }

    @Override
    public ProductResponse createProduct(Product product) {
        log.info("[AuthClient][createProduct] Product: " + product);
        return productsFeignClient.createProduct(product);
    }

    @Override
    public ProductResponse updateProduct(String id, Product product) {
        log.info("[AuthClient][updateProduct] ProductID: " + id + " Product: " + product);
        return productsFeignClient.updateProduct(id, product);
    }

    @Override
    public ProductResponse patchProduct(String id, Product product) {
        log.info("[AuthClient][patchProduct] ProductID: " + id + " Product: " + product);
        return productsFeignClient.patchProduct(id, product);
    }

    @Override
    public ProductResponse deleteProduct(String id) {
        log.info("[AuthClient][deleteProduct]"+"ProductID: " + id);
        return productsFeignClient.deleteProduct(id);
    }
}
