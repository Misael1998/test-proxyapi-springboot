package dev.fakestore.service.impl;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.proxy.client.ICartClient;
import dev.fakestore.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final ICartClient cartClient;

    @Override
    public ArrayList<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate) {
        log.info("[CartService][getAllCarts]: " +
                ((n == null) && (sort == null) ? "":"Filter -> ") +
                (sort == null ? "":" Sort order: "+sort.getSort()) +
                (n == null ? "":" Products to be retrieve: "+n) +
                (startdate == null ? "":" Start Date: "+startdate) +
                (enddate == null ? "":" End Date: "+enddate));
        return cartClient.getAllCarts(
                n,
                sort,
                startdate,
                enddate);
    }

    @Override
    public ArrayList<CartResponse> getAllUserCarts(Integer id) {
        log.info("[CartService][getAllUserCarts] UserId: " + id);
        return cartClient.getAllUserCarts(id);
    }

    @Override
    public CartResponse createProduct(Cart cart) {
        log.info("[CartService][createProduct] Product: " + cart);
        return cartClient.createProduct(cart);
    }

    @Override
    public CartResponse updateProduct(Integer id, Cart cart) {
        log.info("[CartService][createProduct] ProductId: "+ id + " Product: " + cart);
        return cartClient.updateProduct(id, cart);
    }

    @Override
    public CartResponse patchProduct(Integer id, Cart cart) {
        log.info("[CartService][patchProduct] ProductId: "+ id + " Product: " + cart);
        return cartClient.patchProduct(id, cart);
    }

    @Override
    public CartResponse deleteProduct(Integer id) {
        log.info("[CartService][deleteProduct] ProductID: " + id);
        return cartClient.deleteProduct(id);
    }
}
