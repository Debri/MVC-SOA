package com.geek.order.persistence;

import com.geek.order.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "update order set trade_id = ?1 ,trade_status=1 where id =?2 ", nativeQuery = true)
    public void updateOrderByTrade(Long tradeId, Long id);

    public Iterable<Order> findByUserId(Long userId);
    @Query(value = "select * from order" ,nativeQuery = true)
    public Iterable<Order> find();

}
