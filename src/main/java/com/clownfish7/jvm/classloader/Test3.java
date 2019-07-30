package com.clownfish7.jvm.classloader;

import java.util.UUID;

/**
 * @author yzy
 * @classname Test3
 * @description TODO
 * @create 2019-07-29 15:59
 */

/**
 * 当一个常量值并非编译期间可以确定的，那么这个常量不会被放到调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致该类初始化
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }
}

class Parent3 {
    public static final String str = UUID.randomUUID().toString();
    static{
        System.out.println("Parent static block");
    }
}
