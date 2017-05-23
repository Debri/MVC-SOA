package com.geek.controller;

import com.geek.order.domain.Order;
import com.geek.order.facade.OrderFacade;
import com.geek.product.domain.Product;
import com.geek.product.facade.ProductFacade;
import com.geek.trade.domain.Trade;
import com.geek.trade.facade.TradeFacade;
import com.geek.user.facade.UserFacade;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
@Controller
public class TestController {
    @Resource
    private UserFacade userFacade;

    @Resource
    private ProductFacade productFacade;

    @Resource
    private OrderFacade orderFacade;

    @Resource
    private TradeFacade tradeFacade;

    @RequestMapping(value = "/test")
    public void index(HttpServletResponse response) throws IOException, ParseException {
        Long userId = this.login();
        List<Product> products = (List<Product>) productFacade.findAllProduct();
        Product product = products.get(0);

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(product.getId());
        order.setPrice(product.getPrice());
        this.orderFacade.createOrder(order);
        // 4.实现订单交易支付
        Trade trade = new Trade();
        trade.setUserId(order.getUserId());
        trade.setOrderId(order.getId());
        trade.setPrice(order.getPrice());
        trade.setPayType(1);// 支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付
        trade.setPayStatus(4);// 1 未付款 2 付款中 3 付款失败 4 付款完成
        trade.setGatewayPayNum(String.valueOf((new Date()).getTime()));// 网关支付流水号取当前时间
        trade.setGatewayPayPrice(order.getPrice());
        trade.setGatewayPayTime(new Date());
        this.tradeFacade.createTrade(trade);
        // 5.查看所有的订单信息
        List<Order> orders = (List<Order>) this.orderFacade.findOrderByUserId(userId);

        PrintWriter writer = response.getWriter();
        for (Order obj : orders) {
            writer.print(obj.toString());
            writer.println();
        }
    }

    private Long login() {
        String username = "admin";
        String password = "admin";
        Long id = userFacade.login(username, password);
        if (id != null) {
            System.out.println("登陆成功 id = " + id);
        } else {
            System.out.println("登陆失败");
        }
        return id;
    }
}
