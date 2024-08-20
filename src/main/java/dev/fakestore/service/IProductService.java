package dev.fakestore.service;

import dev.fakestore.domain.dto.Product;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.ProductResponse;

import java.util.List;

/**
 * Interface containing the payment methods
 *
 * @author Misael Landero
 */
public interface IProductService {
    /**
     * <p>
     *     This method gets all products unfiltered and filtered
     * </p>
     * @param n N
     * @param sort Sort
     * @return Product respose
     */
    List<ProductResponse> getAllProducts(Integer n, Sort sort);

    /**
     * <p>
     *     This method gets all categories
     * </p>
     * @return List of String
     */
    List<String> getAllCategories();

    /**
     * <p>
     *     This method gets all products associated to one category
     * </p>
     * @param category Category
     * @return List of Product Response
     */
    List<ProductResponse> getAllProductsInCategory(String category);

    /**
     * <p>
     *     This method creates a new product
     * </p>
     * @param product Product
     * @return Product Response
     */
    ProductResponse createProduct(Product product);

    /**
     * <p>
     *     This method updates a product
     * </p>
     * @param id ID
     * @param product Product
     * @return
     */
    ProductResponse updateProduct(Integer id, Product product);

    /**
     * <p>
     *     This method patches a product
     * </p>
     * @param id ID
     * @param product Product
     * @return
     */
    ProductResponse patchProduct(Integer id, Product product);

    /**
     * <p>
     *     This method deletes a product
     * </p>
     * @param id ID
     * @return Product Response
     */
    ProductResponse deleteProduct(Integer id);

    /**
     * <p>
     *     This method gets a product by its id
     * </p>
     * @param id ID
     * @return Product Response
     */
    ProductResponse getProductById(Integer id);
}
