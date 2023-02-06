import java.sql.*;

public class dbManager {
    private Connection conn;
    private Statement statement;
    public dbManager() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://sql7.freesqldatabase.com/sql7596281",
                    "sql7596281",
                    "5V4U7k7EwE"
            );

            statement = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
