package com.dujiu.sedimentation.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 日志切面类
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 切点
     */
    @Pointcut("@annotation(com.dujiu.sedimentation.aop.annotation.Log)")
    public void pointCut(){}

    /**
     * 目标方法执行前记录入参
     */
    @Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("【日志-前置】调用时间：" + new Date());
        System.out.println("【日志-前置】方法名：" + methodName);
        System.out.println("【日志-前置】入参：" + args);
    }

    /**
     * 统计方法执行耗时（能控制目标方法是否执行）
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("【日志-环绕】耗时：" + (endTime - startTime) + "ms");
        return result;
    }

    /**
     * 目标方法成功返回后记录结果
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturningLog(Object result) {
        System.out.println("【日志-返回后】返回结果：" + result);
    }
}
