package com.geek.trade.facade;

import com.geek.order.domain.Order;
import com.geek.order.facade.OrderFacade;
import com.geek.trade.domain.Trade;
import com.geek.trade.persistence.TradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
@Service
public class TradeFacadeImpl implements TradeFacade {
    @Resource
    private TradeRepository tradeRepository;

    @Resource
    private OrderFacade orderFacade;

    public void createTrade(Trade trade) {
        tradeRepository.save(trade);
        Order order = new Order();
        order.setId(trade.getOrderId());
        order.setTradeId(order.getId());
        orderFacade.updateOrderByTrade(order);

    }
}
