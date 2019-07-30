package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test4
 * @description TODO
 * @create 2019-07-29 16:21
 */

/**
 * 对于数组实例来说，其类型是由JVM在运行期间动态生成的，表示为 [Lcom.clownfish7.jvm.classloader.Parent4
 * 这种形式动态生成的类型其父类型就是 Object
 *
 * 对于数组来说，JavaDoc 经常将构成数组的元素为 Component ，实际上就是将数组降低一个纬度后的类型。
 *
 * 助记符：
 * anewarray    表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
 * newarray     表示创建一个指定的原始类型的（如 int、float、char 等）数组，并将其引用值压入栈顶
 */
public class Test4 {
    public static void main(String[] args) {
//        Parent4 parent4 = new Parent4();
        Parent4[] parent4s = new Parent4[1];
        System.out.println(parent4s.getClass());
        Parent4[][] parent4s1 = new Parent4[1][1];
        System.out.println(parent4s1.getClass());

        System.out.println("======");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
    }
}

class Parent4 {
    static {
        System.out.println("Parent static block");
    }
}
