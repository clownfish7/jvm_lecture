package com.clownfish7.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yzy
 * @classname Client
 * @description TODO
 * @create 2019-08-02 16:13
 */
public class Client {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        InvocationHandler dynamicSubject = new DynamicSubject(realSubject);

        Subject o = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), dynamicSubject);

        o.request();
    }
}
