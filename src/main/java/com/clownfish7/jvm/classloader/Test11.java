package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test11
 * @description TODO
 * @create 2019-07-30 11:17
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(Child11.i);
        Child11.doSomething();
    }
}

class Child11 extends Parent11 {
    static {
        System.out.println("child11 static block");
    }
}

class Parent11 {
    static int i = 3;

    static {
        System.out.println("parent11 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}
