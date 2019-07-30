package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname MyCat
 * @description TODO
 * @create 2019-07-30 16:56
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
    }
}
