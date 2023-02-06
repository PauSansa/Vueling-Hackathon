import java.sql.*;
import java.util.stream.Collectors;

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

    public void insertTrip(Trip trip){
        String name = trip.getName();
        String type = trip.getType();
        int duration = trip.getDuration();
        String cities = String.join(", ", trip.getCities());
        String details = trip.getDetails().entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining(", "));

        try {
            statement.executeUpdate(String.format(
                    "INSERT INTO prueba_trips (name, type, duration, cities, details)" +
                            " VALUES('%s', '%s', %d, '%s', '%s')",
                    name, type, duration, cities, details
            ));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
