package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test5
 * @description TODO
 * @create 2019-07-29 17:05
 */

import java.util.Random;

/**
 * 当一个接口在初始化时并不要求其父接口都完成初始化
 * 只有在真正用到父接口的时候（如引用接口中定义的常量），才会初始化
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}

interface Parent5 {
    public static final int a = 5;
}

interface Child5 extends Parent5 {
    public static final int b = new Random().nextInt(2);
}