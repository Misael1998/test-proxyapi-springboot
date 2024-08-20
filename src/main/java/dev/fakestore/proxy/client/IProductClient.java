package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;

import java.util.List;

public interface IProductClient {
    List<ProductResponse> getAllProducts(Integer n, Sort sort);
    List<String> getAllCategories();
    List<ProductResponse> getAllProductsInCategory(String category);
    ProductResponse createProduct(Product product);
    ProductResponse updateProduct(Integer id, Product user);
    ProductResponse patchProduct(Integer id, Product user);
    ProductResponse deleteProduct(Integer id);
    ProductResponse getProductById(Integer id);
}
