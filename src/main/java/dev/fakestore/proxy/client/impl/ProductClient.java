package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.proxy.client.IProductClient;
import dev.fakestore.proxy.feign.ProductsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Payment Service Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductClient implements IProductClient {

    private final ProductsFeignClient productsFeignClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductResponse> getAllProducts(Integer n, Sort sort) {
        log.info("[ProductClient][getAllProducts]: " +
                ((n == null) && (sort == null) ? "":"Filter ->") +
                (sort == null ? "":" Sort order: "+sort.getSort()) +
                (n == null ? "":" Products to be retrieve: "+n));
        return productsFeignClient.getAllProducts(n, sort == null ? null : sort.getSort());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllCategories() {
        log.info("[ProductClient][getAllCategories]");
        return productsFeignClient.getAllCategories();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductResponse> getAllProductsInCategory(String category) {
        log.info("[ProductClient][getAllProductsInCategory] Category: " + category);
        return productsFeignClient.getAllProductsInCategory(category);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse createProduct(Product product) {
        log.info("[ProductClient][createProduct] Product: " + product);
        return productsFeignClient.createProduct(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse updateProduct(Integer id, Product product) {
        log.info("[ProductClient][updateProduct] ProductID: " + id + " Product: " + product);
        return productsFeignClient.updateProduct(id, product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse patchProduct(Integer id, Product product) {
        log.info("[ProductClient][patchProduct] ProductID: " + id + " Product: " + product);
        return productsFeignClient.patchProduct(id, product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse deleteProduct(Integer id) {
        log.info("[ProductClient][deleteProduct]"+"ProductID: " + id);
        return productsFeignClient.deleteProduct(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse getProductById(Integer id) {
        log.info("[ProductClient][getProductById]"+"ProductID: " + id);
        return productsFeignClient.getProductById(id);
    }
}
