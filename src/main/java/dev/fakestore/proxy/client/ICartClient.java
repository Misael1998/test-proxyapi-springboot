package dev.fakestore.proxy.client;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.domain.response.ProductResponse;

import java.util.ArrayList;
import java.util.Date;

public interface ICartClient {
    ArrayList<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate);
    ArrayList<CartResponse> getAllUserCarts(Integer integer);
    ProductResponse createProduct(Cart cart);
    CartResponse updateProduct(String id, Cart cart);
    CartResponse patchProduct(String id, Cart cart);
    CartResponse deleteProduct(String id);
}
