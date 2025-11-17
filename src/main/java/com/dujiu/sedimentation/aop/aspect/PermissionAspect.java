package com.dujiu.sedimentation.aop.aspect;

import com.dujiu.sedimentation.aop.service.OrderService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 权限校验切面类
 */
@Aspect
@Component
public class PermissionAspect {

    private final OrderService orderService;

    public PermissionAspect(OrderService orderService) {
        this.orderService = orderService;
    }

    @Pointcut("@annotation(com.dujiu.sedimentation.aop.annotation.CheckPermission)")
    public void permissionPointcut(){}

    @Before("permissionPointcut()")
    public void checkPermission(JoinPoint joinPoint) {
        Long currentId = getCurrentIdFromRequest();
        Object[] args = joinPoint.getArgs();
        // 假设args第一个参数为订单id
        Long orderId = (Long) args[0];
        Long ownerId = orderService.getOrderOwnerId(orderId);
        if (!currentId.equals(ownerId)) {
            throw new RuntimeException("无权限访问");
        }
    }

    /**
     * 模拟从请求中获取用户id
     */
    private Long getCurrentIdFromRequest() {
        return 123L;
    }
}
