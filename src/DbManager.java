import java.sql.*;
import java.util.stream.Collectors;

public class DbManager {
    private Connection conn;
    private Statement stmt;

    //Constructor of the dbManager
    public DbManager() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://sql7.freesqldatabase.com/sql7596281",
                    "sql7596281",
                    "5V4U7k7EwE"
            );

            stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //It deletes a trip by its name
    public void removeTrip(String name) {
        String query = String.format("DELETE FROM trips WHERE(name = '%s')", name);
        try{
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean exists(String name){
        String query = String.format("SELECT * FROM trips WHERE name = '%s'",name);
        try {
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()){
                return false;
            } else{
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
            stmt.executeUpdate(String.format(
                    "INSERT INTO trips (name, type, duration, cities, details)" +
                            " VALUES('%s', '%s', %d, '%s', '%s')",
                    name, type, duration, cities, details
            ));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void showAllTrips() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM trips");
            while(rs.next()){
                String tripName = rs.getString("name");
                String tripType = rs.getString("type") + " Trip";
                String tripDuration = rs.getInt("duration") + " days";
                String tripCities = rs.getString("cities");
                String tripDetails = rs.getString("details");

                String finalString = String.join("; ", tripName, tripType, tripDuration, tripCities, tripDetails);
                System.out.println(finalString);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet searchTripsName(String name){
        if (!exists(name)){
            return null;
        }
        try {
            String query = String.format("SELECT * FROM trips WHERE name = '%s'", name);
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet searchTripsCity(String city){
        String formattedString = String.format("%%%s%%", city);
        String query = String.format("SELECT * FROM trips WHERE cities LIKE '%s'",formattedString);
        try {
            return stmt.executeQuery(query);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
