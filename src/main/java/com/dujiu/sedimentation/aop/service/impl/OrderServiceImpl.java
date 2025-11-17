package com.dujiu.sedimentation.aop.service.impl;

import com.dujiu.sedimentation.aop.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 订单服务实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Long getOrderOwnerId(Long orderId) {
        return 123L;
    }

    @Override
    public void deleteOrder(Long orderId) {
        System.out.println("orderServiceImpl被调用了");
    }
}
