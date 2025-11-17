package com.dujiu.sedimentation.proxyTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

/**
 * @author dujiu
 * @date: 2025/10/13
 */
public class ProxyDemo {
    public static UserService getProxy1(final Object target) {

        return (UserService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("[日志] 开始执行: " + method.getName() + " 参数: " + (args != null ? args[0] : "无"));
                    Object result = method.invoke(target, args);
                    System.out.println("[日志] 执行完成: " + method.getName());
                    return result;
                });
    }

    public static UserService getProxy2(final Object target) {

        return (UserService) Enhancer.create(target.getClass(),
                (MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("[日志] 开始执行: " + method.getName() + " 参数: " + (args != null ? args[0] : "无"));
            Object result = proxy.invoke(target, args);
            System.out.println("[日志] 执行完成: " + method.getName());
            return result;
        });
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy1 = getProxy1(userService);
        proxy1.addUser("dujiu");
        proxy1.deleteUser("dujiu");
        UserService proxy2 = getProxy2(userService);
        proxy2.addUser("dujiu");
        proxy2.deleteUser("dujiu");
    }
}
