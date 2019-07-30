package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test1
 * @description
 * @create 2019-07-29 14:35
 */

/**
 * 常量在编译阶段会存入到调用这个常量的方法的所在类的常量池中
 * 本质上，调用类并没有直接引用到这个定义常量的类，因此不会触发定义常量的类的初始化
 * 注意：这里指的是在将常量存放在 Test2 的常量池中，之后 Test2 与 Parent2 就没有任何关系了
 * 甚至，我们可以删除 Parent2 的 class 文件
 *
 * 助记符:
 * ldc      表示将 int, float 或是 String 类型的常量值从常量池中推送至栈顶
 * bipush   表示将单字节 （-128~127） 的常量值推送到栈顶
 * sipush   表示将一个短整型常量值 （-32768~32767） 推送到栈顶
 * iconst_1 表示将 int 类型 1 推送至栈顶 （iconst_m1 ~ iconst_5）
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Parent2.str);
        System.out.println(Parent2.s);
        System.out.println(Parent2.i);
        System.out.println(Parent2.m);
    }
}

class Parent2{
    public static final String str = "hello world";
    public static final short s = 7;
    public static final int i = 128;
    public static final int m = 1;
    static {
        System.out.println("Parent1 static block");
    }
}

