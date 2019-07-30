package com.clownfish7.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author yzy
 * @classname Test14
 * @description TODO
 * @create 2019-07-30 13:37
 */
public class Test14 {
    public static void main(String[] args) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String url = "com/clownfish7/jvm/classloader/Test13.class";
        Enumeration<URL> resources = contextClassLoader.getResources(url);
        while (resources.hasMoreElements()) {
            URL url1 = resources.nextElement();
            System.out.println(url1);
        }
    }
}
