package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test10
 * @description TODO
 * @create 2019-07-30 11:08
 */
public class Test10 {
    static {
        System.out.println("test10 static block");
    }
    public static void main(String[] args) {
        Parent10 parent10;

        System.out.println("--------------");

        parent10 = new Parent10();

        System.out.println("--------------");

        System.out.println(parent10.a);

        System.out.println("--------------");

        System.out.println(Child10.b);

        System.out.println("--------------");
    }
}

class Parent10 {
    static int a = 3;
    static {
        System.out.println("parent10 static block");
    }
}

class Child10 extends Parent10 {
    public static int b = 4;
    static {
        System.out.println("child10 static block");
    }
}
