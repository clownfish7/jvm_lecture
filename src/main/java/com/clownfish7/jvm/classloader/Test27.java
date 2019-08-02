package com.clownfish7.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yzy
 * @classname Test27
 * @description TODO
 * @create 2019-07-31 15:00
 */
public class Test27 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "yzy", "19970806");
    }
}
