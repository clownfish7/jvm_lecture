package com.clownfish7.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @author yzy
 * @classname Test3
 * @description TODO
 * @create 2019-08-02 10:51
 */

/**
 * 对于 JAVA 类中的每一个实例方法（非 static 方法），其在编译后所生成的字节码当中，方法参数的数量总是会必源代码中的方法参数的数量多一个（this），
 * 它位于方法的第一个参数位置处；这样，我们就可以在 Java 的实例方法中使用 this 来去访问当前对象的属性以及其他方法。
 *
 * 这个操作实在编译期间完成的，即由 javac 编译器在编译的时候将对 this 的访问能转化为对一个普通实例方法参数的访问，接下来在运行期间
 * 由 JVM 在调用实例方法时，自动向实例方法传入该 this 参数，所以，在实例方法的局部变量表中，之少会有一个指向当前对象的局部变量。
 */

/**
 * JAVA 字节码对于异常的处理方式：
 *
 * 1.统一采用异常表的方式来对异常进行处理
 * 2.在 jdk 1.4.2 之前的版本中，并不是使用异常表的方式来对异常进行处理的，而实采用特定的指令方式。
 * 3.当异常处理存在 finally 语句块时，现代化的 JVM 采用的处理方式是将 finally 语句块的字节码拼接到每一个 catch 块后面，
 *   换句话说，程序中存在多少个 catch 块，就会在每一个 catch 块后重复多少个 finally 语句块的字节码。
 */
public class Test3 {
    public void test() throws IOException, FileNotFoundException, NullPointerException {
        try {
            InputStream is = new FileInputStream("a.a");

            ServerSocket serverSocket = new ServerSocket(9999);

            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
