package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname RealSubject
 * @description 动态代理字节码
 * @create 2019-08-02 16:08
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("from realsubject request");
    }
}
