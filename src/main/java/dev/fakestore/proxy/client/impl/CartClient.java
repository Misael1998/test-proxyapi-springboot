package dev.fakestore.proxy.client.impl;

import dev.fakestore.domain.dto.Cart;
import dev.fakestore.domain.enumeration.Sort;
import dev.fakestore.domain.response.CartResponse;
import dev.fakestore.proxy.client.ICartClient;
import dev.fakestore.proxy.feign.CartFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Cart Client Implementation
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CartClient implements ICartClient {

    private final CartFeignClient cartFeignClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CartResponse> getAllCarts(Integer n, Sort sort, Date startdate, Date enddate) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CartResponse> getAllUserCarts(Integer id) {
        log.info("[CartClient][getAllUserCarts] UserId: " + id);
        return cartFeignClient.getAllUserCarts(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartResponse createProduct(Cart cart) {
        log.info("[CartClient][createProduct] Product: " + cart);
        return cartFeignClient.createProduct(cart);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartResponse updateProduct(Integer id, Cart cart) {
        log.info("[CartClient][createProduct] ProductId: "+ id + " Product: " + cart);
        return cartFeignClient.updateProduct(id, cart);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartResponse patchProduct(Integer id, Cart cart) {
        log.info("[CartClient][patchProduct] ProductId: "+ id + " Product: " + cart);
        return cartFeignClient.patchProduct(id, cart);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartResponse deleteProduct(Integer id) {
        log.info("[CartClient][deleteProduct]"+"ProductID: " + id);
        return cartFeignClient.deleteProduct(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartResponse getCartById(Integer id) {
        log.info("[CartClient][getCartById]"+"ProductID: " + id);
        return cartFeignClient.getCartById(id);
    }
}
