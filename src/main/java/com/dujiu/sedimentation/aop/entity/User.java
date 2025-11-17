package com.dujiu.sedimentation.aop.entity;


/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 用户实体类
 */
public record User(String name, int age) {
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
