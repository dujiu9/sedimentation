package com.dujiu.sedimentation.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dujiu
 * @date: 2025/10/18
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxyHandler proxy = new ProxyHandler((proxy1, method, args1) -> {
            System.out.println("before...");
            Object result = method.invoke(new TargetImpl(), args1);
            System.out.println("after...");
            return result;
        });
        proxy.eat();
        proxy.sleep();
    }

    interface Target {
        void eat();
        void sleep();
    }

    static class TargetImpl implements Target {
        @Override
        public void eat() {
            System.out.println("TargetImpl.eat()");
        }

        @Override
        public void sleep() {
            System.out.println("TargetImpl.sleep()");
        }
    }

    static class ProxyHandler extends Proxy implements Target {

        public ProxyHandler(InvocationHandler h) {
            super(h);
        }

        static Method eat = null;
        static Method sleep = null;

        static {
            try {
                eat = Target.class.getMethod("eat");
                sleep = Target.class.getMethod("sleep");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void eat() {
            try {
                h.invoke(this, eat, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void sleep() {
            try {
                h.invoke(this, sleep, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
