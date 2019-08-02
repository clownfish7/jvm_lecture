package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname Test2
 * @description TODO
 * @create 2019-08-02 9:21
 */
public class Test2 {
    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.setX(8);
        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str) {
            System.out.println("hello world");
        }
    }

    private synchronized static void test2() {

    }
}
