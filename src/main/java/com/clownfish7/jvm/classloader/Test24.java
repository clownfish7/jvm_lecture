package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test24
 * @description TODO
 * @create 2019-07-31 10:24
 */

/**
 * 当前类加载器（Current  Classloader）
 *
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（指的是所依赖的类）
 * 如果 ClassX 引用了 ClassY 那么 ClassX 的类加载器就会去加载 ClassY （前提是 ClassY 尚未被加载）
 *
 * 线程上下文类加载器（Context Classloader）
 *
 * 线程上下文类加载器是从JDK1.2开始引入的，类 Thread 中的 getContextClassloader() & setContextClassloader(Classloader c)
 * 分别用来获取和设置上下文类加载器
 *
 * 如果没有通过 setContextClassloader() 线程将继承其父线程的上下文类加载器
 * Java 引用运行时的初始线程的上下文类加载器是系统类加载器，在线程中运行的资源可以通过该类加载器来加载类与资源
 *
 * 线程上下文类加载器的重要性：
 *
 * SPI（Service Provider Interface）
 *
 * 父 ClassLoader 可以使用当前线程 Thread.currentThread().getContextClassLoader()所指定的classloader加载的类
 * 这就改变了父 ClassLoader 不能使用子 Cloassloader 或是其他没有直接父子关系的 Classloader 加载的类的情况，即改变了双亲委托模型
 *
 * 线程上下文类加载器就是当前线程的 Current Classloader
 *
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层进行加载，但是对于 SPI 来说，有些接口是 JAVA 核心库所提供的，
 * 而 JAVA 核心库是由启动类加载器加载的，而这些接口的实现却来自于不同的 jar 包（厂商提供），JAVA 的启动类加载器是不会加载其他来源的 JAR
 * 这样传统的双亲委托模型就无法满足 SPI 的要求，而通过给当前线程设置上下文类加载器就可以由设置的上下文类加载器来实现对于接口实现类的加载
 */
public class Test24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
