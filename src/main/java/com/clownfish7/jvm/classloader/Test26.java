package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test26
 * @description TODO
 * @create 2019-07-31 11:51
 */

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式 （ 获取 - 使用 - 还原 ）
 *
 * ClassLoader classloader = Thread.currentThread().getContextClassLoader();
 *
 * try{
 *     Thread.currentThread().setContextClassLoader(targetTccl);
 *     myMethod();
 * }finally{
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 *
 * myMethod 里面调用了 Thread.currentThread().getContextClassLoader(); 获取当前线程的上下文类加载器做某些事情
 *
 * 如果一个类由类加载器A加载，那么这个了的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
 *
 * ContextClassLoader 的作用就是为了破坏 Java 的类加载委托机制
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须通过线程上下文类加载器来帮助高层的 ClassLoader 找到并加载类
 */
public class Test26 {
    public static void main(String[] args) throws ClassNotFoundException {

        Thread.currentThread().setContextClassLoader(Test26.class.getClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver d = iterator.next();
            System.out.println("driver: " + d.getClass() + ", loader: "+ d.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器: "+Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器： "+ServiceLoader.class.getClassLoader());
    }
}
