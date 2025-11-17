package com.dujiu.sedimentation.aop.service;


/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 订单服务接口
 */
public interface OrderService {
    /**
     * 获取订单的拥有者id
     * @param orderId 订单id
     * @return 订单的拥有者id
     */
    Long getOrderOwnerId(Long orderId);

    /**
     * 删除订单
     * @param orderId 订单id
     */
    void deleteOrder(Long orderId);
}
