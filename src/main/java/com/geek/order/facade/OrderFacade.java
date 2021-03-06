package com.geek.order.facade;

import com.geek.order.domain.Order;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
public interface OrderFacade {
    public Iterable<Order> findOrderByUserId(Long userId);

    public Order createOrder(Order order);

    public void updateOrderByTrade(Order order);

}
