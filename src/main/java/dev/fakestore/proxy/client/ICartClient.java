package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;

import java.util.ArrayList;
import java.util.Date;

public interface ICartClient {
    ArrayList<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate);
    ArrayList<CartResponse> getAllUserCarts(Integer integer);
    CartResponse createProduct(Cart cart);
    CartResponse updateProduct(Integer id, Cart cart);
    CartResponse patchProduct(Integer id, Cart cart);
    CartResponse deleteProduct(Integer id);
    CartResponse getCartById(Integer id);
}
