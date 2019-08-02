package com.clownfish7.jvm.bytecode;

/**
 * @author yzy
 * @classname Test1
 * @description TODO
 * @create 2019-07-31 17:40
 */

/**
 * 查看字节码(.class)文件
 * javap -c         Test1.class
 * javap -verbose   Test1.class
 */
public class Test1 {
    private int i = 1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
