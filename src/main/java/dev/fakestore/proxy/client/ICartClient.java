package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;

import java.util.Date;
import java.util.List;

/**
 * <p>Interface containing the cart clients</p>
 *
 * @author Misael Landero
 */
public interface ICartClient {
    /**
     * <p>
     *     This method gets all carts filtered and unfiltered
     * </p>
     * @param n N
     * @param sort Sort
     * @param startdate StartDate
     * @param enddate EndDate
     * @return Cart Response
     */
    List<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate);
    /**
     * <p>
     *     This method gets all carts associated with a user
     * </p>
     * @param integer User ID
     * @return Cart Response
     */
    List<CartResponse> getAllUserCarts(Integer integer);
    /**
     * <p>
     *     This method creates a new cart
     * </p>
     * @param cart Cart Product
     * @return Cart Response
     */
    CartResponse createProduct(Cart cart);
    /**
     * <p>
     *     This method updates the cart
     * </p>
     * @param id ID
     * @param cart Cart
     * @return Cart Response
     */
    CartResponse updateProduct(Integer id, Cart cart);
    /**
     * <p>
     *     This method patches the cart
     * </p>
     * @param id ID
     * @param cart Cart
     * @return Cart Response
     */
    CartResponse patchProduct(Integer id, Cart cart);
    /**
     * <p>
     *     This method deletes a cart
     * </p>
     * @param id ID
     * @return Cart Response
     */
    CartResponse deleteProduct(Integer id);
    /**
     * <p>
     *     This method retrieves a cart by its id
     * </p>
     * @param id ID
     * @return Cart Response
     */
    CartResponse getCartById(Integer id);
}
