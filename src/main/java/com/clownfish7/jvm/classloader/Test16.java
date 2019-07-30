package com.clownfish7.jvm.classloader;

import java.io.*;

/**
 * @author yzy
 * @classname Test16
 * @description 自定义类加载器
 * @create 2019-07-30 14:22
 */
public class Test16 extends ClassLoader {
    private String classLoadName;
    private final String fileExtension = ".class";
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Test16(String classLoadName) {
        super();    // 将系统类加载器作为该加载器的父加载器
        this.classLoadName = classLoadName;
    }

    public Test16(ClassLoader classLoader, String classLoadName) {
        super(classLoader); //显示指定该加载器的父加载器
        this.classLoadName = classLoadName;
    }

    public Test16(ClassLoader parent) {
        super(parent);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;

        try {
            name = name.replace(".", "\\");
            is = new FileInputStream(new File(path + name + fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("Test16 loaded it!");
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    @Override
    public String toString() {
        return "[" + this.classLoadName + "]";
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        Test16 loader1 = new Test16("loader1");
//        loader1.setPath("/d/idea/project/jvm_lecture/out/production/classes");
        loader1.setPath("f:\\");

        Class<?> clazz = loader1.loadClass("com.clownfish7.jvm.classloader.Test2");
        Object o = clazz.newInstance();
        System.out.println(o);
        System.out.println(clazz);
        System.out.println(o.getClass().getClassLoader());
        System.out.println(clazz.hashCode());

        // 卸载

        Thread.sleep(20000);

        loader1 = null;
        clazz = null;
        o = null;
        System.gc();
        Thread.sleep(20000);
        loader1 = new Test16("loader1");
        loader1.setPath("f:\\");

        clazz = loader1.loadClass("com.clownfish7.jvm.classloader.Test2");
        o = clazz.newInstance();
        System.out.println(o);
        System.out.println(clazz);
        System.out.println(o.getClass().getClassLoader());
        System.out.println(clazz.hashCode());

//        System.out.println("-------------");
//        Test16 loader2 = new Test16( loader1,"loader2");
//        loader2.setPath("f:\\");
//        Class<?> clazz2 = loader2.loadClass("com.clownfish7.jvm.classloader.Test2");
//        Object o1 = clazz2.newInstance();
//        System.out.println(o1);
//        System.out.println(o1.getClass().getClassLoader());
//        System.out.println(clazz2.hashCode());
//
//        System.out.println("-------------");
//        Test16 loader3 = new Test16( loader1,"loader2");
//        loader3.setPath("f:\\");
//        Class<?> clazz3 = loader3.loadClass("com.clownfish7.jvm.classloader.Test2");
//        Object o3 = clazz2.newInstance();
//        System.out.println(o3);
//        System.out.println(o3.getClass().getClassLoader());
//        System.out.println(clazz3.hashCode());
    }
}
