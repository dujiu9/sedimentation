package com.dujiu.sedimentation.proxyTest;

/**
 * @author dujiu
 * @date: 2025/10/13
 */
public class UserServiceImpl implements UserService{
    @Override
    public void addUser(String name) {
        System.out.println("添加用户: " + name);
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("删除用户: " + name);
    }
}
