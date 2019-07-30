package com.clownfish7.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author yzy
 * @classname Test21
 * @description TODO
 * @create 2019-07-30 19:04
 */
public class Test21 {
    public static void main(String[] args) throws Exception {
        Test16 loader1 = new Test16("loader1");
        Test16 loader2 = new Test16("loader2");

        loader1.setPath("f://");
        loader2.setPath("f://");

        Class<?> clazz1 = loader1.loadClass("com.clownfish7.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.clownfish7.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);   //true

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        System.out.println(o1 == o2);   //false

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1, o2);
    }
}
