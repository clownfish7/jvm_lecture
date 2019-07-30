package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname MySample
 * @description TODO
 * @create 2019-07-30 16:58
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        new MyCat();
    }
}
