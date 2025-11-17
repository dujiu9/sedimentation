package com.dujiu.sedimentation.aop.annotation;

import java.lang.annotation.*;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String desc() default "默认日志";
}
