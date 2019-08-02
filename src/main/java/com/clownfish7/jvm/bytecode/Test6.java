package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname Test6
 * @description TODO
 * @create 2019-08-02 14:27
 */

/**
 * 方法的动态分派
 *
 * 方法的动态分配涉及一个重要的概念：方法接收者。
 *
 * invokevirtual 字节码指令的多态查找流程
 *
 * 比较方法重载(overload)和方法重写(overwrite)可以得到这样一个结论：
 *
 * 方法重载是静态的，是编译期行为
 * 方法重写是动态的，是运行期行为
 */
public class Test6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test() {
        System.out.println("fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("orange");
    }
}
