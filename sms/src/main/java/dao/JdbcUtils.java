package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Yuquan Zou on 2015/12/25.
 */
public class JdbcUtils {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(JdbcUtils.class.getResourceAsStream("/db.properties"));
            String drivers = String.valueOf(properties.get("drivers"));
            for (String driver : drivers.split(",")) {
                Class.forName(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getUserConnection() {
        return base("user_url", "user_username", "user_password");
    }

    public static Connection getSMSConnection() {
        return base("sms_url", "sms_username", "sms_password");
    }

    public static Connection getEmailConnection() {

        return base("email_url", "email_username", "email_password");
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection base(String url, String username, String pass) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.valueOf(properties.get(url)), String.valueOf(properties.get(username)), String.valueOf(properties.get(pass)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
