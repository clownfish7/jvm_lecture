package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test6
 * @description TODO
 * @create 2019-07-29 17:25
 */
public class Test6 {
    public static void main(String[] args) {
        Singleton instence = Singleton.getInstence();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}

class Singleton {

    public static int counter1 = 1;
    private static Singleton singleton = new Singleton();
    public static Singleton getInstence() {
        return singleton;
    }

    public Singleton() {
        counter1++;
        counter2++;
    }

    public static int counter2 = 1;
}

