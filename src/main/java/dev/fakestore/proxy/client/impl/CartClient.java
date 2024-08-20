package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.proxy.client.ICartClient;
import dev.fakestore.proxy.feign.CartFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartClient implements ICartClient {

    private final CartFeignClient cartFeignClient;

    @Override
    public ArrayList<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate) {
        log.info("[CartClient][getAllCarts]: " +
                ((n == null) && (sort == null) ? "":"Filter -> ") +
                (sort == null ? "":" Sort order: "+sort.getSort()) +
                (n == null ? "":" Products to be retrieve: "+n) +
                (startdate == null ? "":" Start Date: "+startdate) +
                (enddate == null ? "":" End Date: "+enddate));
        return cartFeignClient.getAllCarts(
                n,
                sort == null ? null : sort.getSort(),
                startdate,
                enddate);
    }

    @Override
    public ArrayList<CartResponse> getAllUserCarts(Integer id) {
        log.info("[CartClient][getAllUserCarts] UserId: " + id);
        return cartFeignClient.getAllUserCarts(id);
    }

    @Override
    public CartResponse createProduct(Cart cart) {
        log.info("[CartClient][createProduct] Product: " + cart);
        return cartFeignClient.createProduct(cart);
    }

    @Override
    public CartResponse updateProduct(Integer id, Cart cart) {
        log.info("[CartClient][createProduct] ProductId: "+ id + " Product: " + cart);
        return cartFeignClient.updateProduct(id, cart);
    }

    @Override
    public CartResponse patchProduct(Integer id, Cart cart) {
        log.info("[CartClient][patchProduct] ProductId: "+ id + " Product: " + cart);
        return cartFeignClient.patchProduct(id, cart);
    }

    @Override
    public CartResponse deleteProduct(Integer id) {
        log.info("[CartClient][deleteProduct]"+"ProductID: " + id);
        return cartFeignClient.deleteProduct(id);
    }
}
