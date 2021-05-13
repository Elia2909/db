package mate.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;

public class ConnectionDB {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "root");
            dbProperties.put("password", "Ilia290900RR");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/liblary_db", dbProperties);
        } catch (SQLException throwables) {
            throw new RuntimeException("Cant create connection", throwables);
        }
    }
}
