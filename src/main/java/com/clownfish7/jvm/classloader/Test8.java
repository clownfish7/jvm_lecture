package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test8
 * @description TODO
 * @create 2019-07-30 10:52
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.i);
    }
}

class FinalTest {
    public static final int i = 3;
    static {
        System.out.println("FinalTest static block");
    }
}
