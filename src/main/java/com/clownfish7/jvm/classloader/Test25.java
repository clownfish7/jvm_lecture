package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test25
 * @description TODO
 * @create 2019-07-31 11:42
 */
public class Test25 implements Runnable {

    private Thread thread;

    public Test25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = thread.getContextClassLoader();

        thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {

        /**
         * Launcher 中
         * Thread.currentThread().setContextClassLoader(this.loader);
         */
        new Test25();
    }
}
