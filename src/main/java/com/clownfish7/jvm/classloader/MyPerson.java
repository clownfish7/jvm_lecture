package com.clownfish7.jvm.classloader;

/**
 * @author yzy
 * @classname MyPerson
 * @description TODO
 * @create 2019-07-30 18:49
 */
public class MyPerson {
    public void setMyPerson(Object o) {
        MyPerson person = (MyPerson) o;
        System.out.println("setMyPerson invoke success");
    }
}
