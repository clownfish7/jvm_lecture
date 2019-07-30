package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test17
 * @description TODO
 * @create 2019-07-30 16:59
 */
public class Test17 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test16 classloader = new Test16("loader1");

        Class<?> clazz = classloader.loadClass("com.clownfish7.jvm.classloader.MySample");
        System.out.println("class: "+ clazz.hashCode());

        Object o = clazz.newInstance();
    }
}
