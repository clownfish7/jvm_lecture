package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test23
 * @description TODO
 * @create 2019-07-30 20:03
 */

import sun.misc.Launcher;

/**
 * 在运行期间，一个 JAVA 类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）所共同决定的，
 * 如果名字相同（即相同的完全限定名）的类是由两个不同的加载器加载的，那么这些类就是不同的，即便 .class 文件的字节码完全一样，并且从相同位置加载亦是如此。
 */
public class Test23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /**
         * 内建与 JVM 中的启动类加载器会加载 java.lang.ClassLoader 以及其他的 JAVA 平台类
         * 当 JVM 启动时，一块特殊的机器码会运行，它会加载扩展类加载器和系统类加载器
         * 这块特殊的机器码叫做启动类加载器（Bootstrap）
         *
         * 启动类加载器并不是 JAVA 类，而其他加载类都是 JAVA 类
         * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。
         *
         * 所有类加载器除了启动类加载器都被实现为 JAVA 类，总归有一个组件加载第一个 JAVA 类加载器， 从而让整个加载过程能够顺利
         * 进行下去，加载第一个纯 JAVA 类加载器就是启动类加载器的职责
         *
         * 启动类加载器还会负责加载供 JRE 正常运行的基本组件，这包括 java.util & java.lang 包中的类等等。
         */

        System.out.println(ClassLoader.class.getClassLoader());

        //  扩展类加载器 & 系统类加载器 也是有启动类加载器负责加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("----------------");

        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(Test23.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
