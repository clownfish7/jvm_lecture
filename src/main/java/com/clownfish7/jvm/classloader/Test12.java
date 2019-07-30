package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test12
 * @description TODO
 * @create 2019-07-30 11:39
 */

/**
 * ClassLoader 类的 loadClass 方法加载一个类，并不表示对一个类的主动使用，不会导致类的初始化
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = systemClassLoader.loadClass("com.clownfish7.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("-------");

        clazz = Class.forName("com.clownfish7.jvm.classloader.CL");
        System.out.println(clazz);

    }
}

class CL {
    static {
        System.out.println("CL static block");
    }

    void doSomething() {
        System.out.println("something");
    }
}