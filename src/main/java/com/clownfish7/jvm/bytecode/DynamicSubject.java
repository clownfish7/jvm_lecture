package com.clownfish7.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yzy
 * @classname DynamicSubject
 * @description TODO
 * @create 2019-08-02 16:10
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before calling");
        Object o = method.invoke(sub, args);
        System.out.println("invoke after calling");
        return o;
    }
}
