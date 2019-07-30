package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test1
 * @description
 * @create 2019-07-29 14:35
 */

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完成
 * -XX:+TraceClassLoading   用于追踪类的加载信息并打印
 * -XX:+TraceClassUnLoading 用于追踪类的卸载信息并打印
 *
 * -XX:+<option>        表示开启option选项
 * -XX:-<option>        表示关闭option选项
 * -XX:<option>=<value> 表示将option选项值设置为value
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Child1.str2);
    }
}

class Parent1{
    public static String str = "hello world";

    static {
        System.out.println("Parent1 static block");
    }
}

class Child1 extends Parent1 {
    public static String str2 = "welcome";
    static{
        System.out.println("Child1 static block");
    }
}
