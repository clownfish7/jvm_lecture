package com.clownfish7.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author yzy
 * @classname Test18
 * @description TODO
 * @create 2019-07-30 17:59
 */
public class Test18 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        Test16 loader1 = new Test16("loader1");
        loader1.setPath("f://");

        Class<?> clazz = loader1.loadClass("com.clownfish7.jvm.classloader.Test1");
        System.out.println(clazz.getClassLoader());

        System.out.println("------------");
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
    }
}
