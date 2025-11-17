package com.dujiu.sedimentation.aop.controller;

import com.dujiu.sedimentation.aop.service.OrderService;
import com.dujiu.sedimentation.aop.annotation.CheckPermission;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 订单控制器
 */
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CheckPermission("order:delete")
    @DeleteMapping("/order/delete")
    public String deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return "删除成功，订单id：" + orderId;
    }
}
