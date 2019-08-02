package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname Test5
 * @description TODO
 * @create 2019-08-02 14:06
 */

/**
 * 方法的静态分派
 *
 * Grandpa g1 = new Father();
 *
 * 以上代码，g1 的静态类型是 Grandpa ，而 g1 的实际类型（真正指向的类型）是 Father
 *
 * 我们可以得出一个结论：变量的静态类型是不会发生变化的，而变量的实际类型是会发生变化的（多态的体现），实际类型是在运行期方可确定
 */
public class Test5 {
    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Test5 test5 = new Test5();
        test5.test(g1);
        test5.test(g2);
    }

    // 方法重载，是一种静态的行为，编译期间就可以完全确定

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
