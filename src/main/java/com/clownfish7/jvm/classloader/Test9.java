package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname RealSubject
 * @description TODO
 * @create 2019-07-30 11:02
 */
public class Test9 {
    static {
        System.out.println("test static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}

class Parent {
    public static int a = 3;
    static {
        System.out.println("parent static block");
    }
}

class Child extends Parent {
    public static int b = 4;
    static {
        System.out.println("child static block");
    }
}
