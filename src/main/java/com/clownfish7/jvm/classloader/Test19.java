package com.clownfish7.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author yzy
 * @classname Test19
 * @description TODO
 * @create 2019-07-30 18:50
 */

/**
 * 类加载器的双亲委托机制的好处：
 *
 * 1.可以确保 JAVA 核心库的类型安全：所有的 JAVA 应用都至少会引用 java.lang.Object 类，也就是说在运行期，java.lang.Object 这个类会被加载到 JVM 虚拟机中
 * 如果这个加载过程是由 JAVA 应用自己的类加载器完成的，那么很可能在 JVM 中存在多个版本的 java.lang.Object 类，而且这些类之间不兼容，相互不可见（命名空间作用）
 * 借助于双亲委托机制，JAVA 核心类库中的类的加载工作都是由启动类加载器来统一完成，从而确保 JAVA 应用是同一个版本的核心类库，他们之间相互兼容。
 * 2.可以确保 JAVA 核心类库的类不会被自定义的类所替代。
 * 3.不同的类加载器可以被相同名称的类创建额外的命名空间，相同名称的类可以并存在 JVM 虚拟机中，只需要用不同的类加载器加载他们即可，不同的类加载器所加载的类之间不可见
 * 这就相当于在 JAVA 虚拟机内部创建了一个又一个的相互隔离的 JAVA 类空间，这类技术在很多框架中都得到实际应用。
 */
public class Test19 {
    public static void main(String[] args) throws Exception {
        Test16 loader1 = new Test16("loader1");
        Test16 loader2 = new Test16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.clownfish7.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.clownfish7.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);   //true

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        System.out.println(o1 == o2);   //false

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1, o2);
    }
}
