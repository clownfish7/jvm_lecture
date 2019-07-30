package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test7
 * @description TODO
 * @create 2019-07-30 10:44
 */
public class Test7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.clownfish7.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}
