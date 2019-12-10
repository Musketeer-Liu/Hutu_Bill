package util;

import sun.tools.java.ClassNotFound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 不要在每个 DAO 里自行创建 Connection，而是放在一个工具类中 这样 DAO 直接调用就可以了
 * 如果账号密码发生变化只用修改这一个地方 降低维护成本
 */
public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

}
