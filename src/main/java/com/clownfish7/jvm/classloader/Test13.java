package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test13
 * @description TODO
 * @create 2019-07-30 11:48
 */
public class Test13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        if (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}

