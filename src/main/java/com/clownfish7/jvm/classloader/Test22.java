package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname Test22
 * @description TODO
 * @create 2019-07-30 19:49
 */

/**
 * 扩展类加载器需要打成jar包
 * jar cvf test.jar com/clownfish7/jvm/classloader/Test1.class
 * java -Djava.ext.dirs=./ com.clownfish7.jvm.classloader.Test22
 * Test22 Initializer
 * sun.misc.Launcher$AppClassLoader@139a55
 * sun.misc.Launcher$ExtClassLoader@1909752
 */
public class Test22 {
    static {
        System.out.println("Test22 Initializer");
    }
    public static void main(String[] args) {
        System.out.println(Test22.class.getClassLoader());
        System.out.println(Test1.class.getClassLoader());
    }
}
