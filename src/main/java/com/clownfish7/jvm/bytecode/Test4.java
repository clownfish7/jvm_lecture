package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname Test4
 * @description TODO
 * @create 2019-08-02 12:15
 */

/**
 * 栈帧（stack frame）
 * <p>
 * 栈帧是一种用于昂住虚拟机执行方法调用与方法执行的数据结构。
 * <p>
 * 栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 * <p>
 * 符号引用，直接引用
 * <p>
 * 有些符号一你用实在类加载阶段或是第一次使用时就会转换为直接引用，这种转换叫做进台解析；
 * 另一些符号引用则是在每次运行期转换为直接引用，这种转换叫做动态链接，体现为 JAVA 的多态性。
 * Animal a = new Cat();
 * a.sleep();
 * a = new Dog();
 * a.sleep();
 * a = new Tiger();
 * a.sleep();
 * <p>
 * 1. invokeinterface  调用接口中的方法，实际上是在运行期决定的，决定到底调用该接口的哪个对象的特定方法
 * 2. invokestatic     调用静态方法
 * 3. invokespecial    调用自己的私有方法、构造方法(<init>)以及父类方法
 * 4. invokeevirtual   调用虚方法，运行期动态查找的过程
 * 5. invokedynamic    动态调用方法
 * <p>
 * 静态解析的 4 中情形：
 * 1. 静态方法
 * 2. 父类方法
 * 3. 构造方法
 * 4. 私有方法
 * 以上 4 类方法称作非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用的
 */
public class Test4 {
    public static void test() {
        System.out.println("test invoke");
    }

    public static void main(String[] args) {
        test();
    }
}
