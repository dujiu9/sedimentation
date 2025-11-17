package com.dujiu.sedimentation.proxyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dujiu
 * @date: 2025/10/17
 */
public class TestAgent {
    public static void main(String[] args) {
        ProxyImpl p = new ProxyImpl((proxy,method, args1) -> {
            System.out.println("before");
            Object result = method.invoke(new TargetImpl(), args1);
            System.out.println("after");
            return result;
        });

        p.eat();
        p.drink();
    }

    /**
     * 目标接口
     */
    interface Target {
        void eat();
        void drink();
    }

    /**
     * InvocationHandler
     */
    // interface InvocationHandler {
    //     void invoke(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
    // }

    /**
     * 目标对象（原始对象）
     */
    static class TargetImpl implements Target {
        @Override
        public void eat() {
            System.out.println("TargetImpl.eat()");
        }

        @Override
        public void drink() {
            System.out.println("TargetImpl.drink()");
        }
    }

    /**
     * 代理对象
     */
    static class ProxyImpl extends Proxy implements Target{
        public ProxyImpl(java.lang.reflect.InvocationHandler h) {
            super(h);
        }

        static Method eat = null;
        static Method drink = null;
        static {
            try {
                eat = Target.class.getMethod("eat");
                drink = Target.class.getMethod("drink");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void eat() {
            try {
                h.invoke(this,eat, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void drink() {
            try {
                h.invoke(this,drink, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}

