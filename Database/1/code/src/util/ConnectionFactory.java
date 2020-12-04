package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    /*information for connection*/
    private static final String url = "jdbc:mysql://localhost:3306/teacher_student";
    private static final String username = "root";
    private static final String password = "123456789";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
