package com.swing.util;

import java.sql.*;

/**
 * @ProjectName: dictionary
 * @Author: swing
 * @CreateDate: 2021/2/24 13:15
 * @UpdateDate: 2021/2/24 13:15
 * @Version: 1.0
 */

public class SqliteUtils {

    public SqliteUtils() {
    }

    public static Connection getConnection(String url) throws SQLException {
        String connPath = String.format("jdbc:sqlite:%s", url);
        Connection conn = null;
        try {
            String driverClass = "org.sqlite.JDBC";
            Class.forName(driverClass);
            System.out.println("数据库驱动加载成功");
            conn = DriverManager.getConnection(connPath);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        } catch (SQLException var4) {
            var4.printStackTrace();
            throw var4;
        }
        return conn;
    }

    public static ResultSet executeQuery(Connection conn, String sql) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery(sql);
    }
}
