package com.geek.trade.persistence;

import com.geek.trade.domain.Trade;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
public interface TradeRepository extends CrudRepository<Trade, Long> {
}
