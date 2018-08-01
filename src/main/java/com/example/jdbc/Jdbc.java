package com.example.jdbc;

import java.sql.*;

/**
 * @author WJ
 * @date 2018/08/01
 */
public class Jdbc {
//    private String url = "jdbc:mysql://localhost:3306/springbootdb";
//    private static String user = "root";
//    private static String password = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //前期准备工作
        String url = "jdbc:mysql://localhost:3306/springbootdb";
        String user = "root";
        String password = "root";


        //1.注册驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.使用驱动管理类获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.准备sql
        String sql = "SELECT * FROM city";
        //4.在连接的基础上，创建Statement
        Statement statement = connection.createStatement();
        //5.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        printDB(resultSet);
        //6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void printDB(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + ","
                    + resultSet.getString(3) + resultSet.getString(4));
        }
    }
}
