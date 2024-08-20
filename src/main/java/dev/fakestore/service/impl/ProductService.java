package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;
import dev.fakestore.proxy.client.IProductClient;
import dev.fakestore.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Payment Client Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductClient productClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductResponse> getAllProducts(Integer n, Sort sort) {
        log.info("[ProductService][getAllProducts]: " +
                ((n == null) && (sort == null) ? "":"Filter ->") +
                (sort == null ? "":" Sort order: "+sort.getSort()) +
                (n == null ? "":" Products to be retrieve: "+n));
        return productClient.getAllProducts(n, sort);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllCategories() {
        log.info("[ProductService][getAllCategories]");
        return productClient.getAllCategories();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductResponse> getAllProductsInCategory(String category) {
        log.info("[ProductService][getAllProductsInCategory] Category: " + category);
        return productClient.getAllProductsInCategory(category);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse createProduct(Product product) {
        log.info("[ProductService][createProduct] Product: " + product);
        return productClient.createProduct(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse updateProduct(Integer id, Product product) {
        log.info("[ProductService][updateProduct] ProductID: " + id + " Product: " + product);
        return productClient.updateProduct(id, product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse patchProduct(Integer id, Product product) {
        log.info("[ProductService][patchProduct] ProductID: " + id + " Product: " + product);
        return productClient.patchProduct(id, product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse deleteProduct(Integer id) {
        log.info("[ProductService][deleteProduct] ProductID: " + id);
        return productClient.deleteProduct(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductResponse getProductById(Integer id) {
        log.info("[ProductService][getProductById] ProductID: " + id);
        return productClient.getProductById(id);
    }
}
