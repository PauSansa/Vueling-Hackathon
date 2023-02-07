import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TravelManager {
    private DbManager dbManager;

    public TravelManager() {
        dbManager = new DbManager();
    }




    //It returns a list of trips that contain the received city
    public void searchTripCity(){
        String city = null;
        boolean correct = false;
        List<Trip> matches;
        while(!correct) {
            try {
                String keyphrase = Entrys.stringEntry("Enter the city of the flight. EX: Madrid");
                if (keyphrase.length() < 3) {
                    throw new WrongInputException();
                } else {
                    city = keyphrase;
                    correct = true;
                }
            } catch (WrongInputException e) {
                System.out.println("Wrong Input, you must enter 3 chars minimum");
            }
        }

        ResultSet rs = this.dbManager.searchTripsCity(city);
        try {
            if (rs.next()) {
                String tripName = rs.getString("name");
                String tripType = rs.getString("type") + " Trip";
                String tripDuration = rs.getInt("duration") + " days";
                String tripCities = rs.getString("cities");
                String tripDetails = rs.getString("details");

                String finalString = String.join("; ", tripName, tripType, tripDuration, tripCities, tripDetails);
                System.out.println(finalString);
            } else {
                System.out.println("There is no trips with this city");
                return;
            }

            while (rs.next()){
                String tripName = rs.getString("name");
                String tripType = rs.getString("type") + " Trip";
                String tripDuration = rs.getInt("duration") + " days";
                String tripCities = rs.getString("cities");
                String tripDetails = rs.getString("details");

                String finalString = String.join("; ", tripName, tripType, tripDuration, tripCities, tripDetails);
                System.out.println(finalString);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }



    }

    public void searchTripName(){
        String name = null;
        boolean correct = false;
        List<Trip> matches;
        while(!correct) {
            try {
                String keyphrase = Entrys.stringEntry("Enter the name of the flight. EX: Exotic Trip");
                if (keyphrase.length() < 0) {
                    throw new WrongInputException();
                } else {
                    name = keyphrase;
                    correct = true;
                }
            } catch (WrongInputException e) {
                System.out.println("Wrong Input, you must enter a String");
            }
        }
        ResultSet rs = this.dbManager.searchTripsName(name);




        try{
            while(rs.next()){
                String tripName = rs.getString("name");
                String tripType = rs.getString("type") + " Trip";
                String tripDuration = rs.getInt("duration") + " days";
                String tripCities = rs.getString("cities");
                String tripDetails = rs.getString("details");

                String finalString = String.join("; ", tripName, tripType, tripDuration, tripCities, tripDetails);
                System.out.println(finalString);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    //It deletes a trip if exists using the name of the trip as a parameter
    public void deleteTrip(){
        String tripName = Entrys.stringEntry("Enter the name of the trip to delete:");

        if (!this.dbManager.exists(tripName)) {
            System.out.println("This trips doesnt exists");
            return;
        } else{
            this.dbManager.removeTrip(tripName);
            System.out.println("The trip has been deleted successfully \n");
        }



    }


    //Creates a trip using method createTrip(), and, if it doesn't exist, it adds it to the travels list
    public void addTrip() {
        int tripType;
        Trip trip = null;
        boolean correct = false;
    

        System.out.println("Its an AirTrip(1) or an LandTrip(2) ??");
        while (!correct) {
            try {
                tripType = Entrys.intEntry("Select 1 or 2");
                if (tripType == 1 || tripType == 2) {
                    trip = createTrip(tripType);
                    correct = true;
                } else {
                    throw new WrongInputException();
                }
            } catch (WrongInputException e) {
                System.out.println("Wrong input, you have to enter 1 or 2 ");
            }
        }

        if (!this.dbManager.exists(trip.getName())){
            dbManager.insertTrip(trip);
            System.out.println("The trip has been added to the database");
        } else{
            System.out.println("This trip is already in the database");
        }


    }


    //Creates a trip depends on the type
    public Trip createTrip(int type){
        //INPUT OF THE NAME
        String tripName = Entrys.stringEntry("Enter the name of the trip: \n");

        //INPUT OF THE DURATION
        int tripDuration = Entrys.intEntry("Enter the duration of the trip \n");

        //INPUT OF THE LIST OF CITIES
        List<String> tripCities = Arrays.stream(Entrys
                        .stringEntry("Enter the names of the cities separated by commas ex(Madrid,London,Madrid)")
                        .split(","))
                .toList();

        //1 = Air, 2 = Land, It creates the details invoking the static method and return an instance of the type of trip
        if (type == 1){
            Map<String,String> tripDetails = AirTrip.createDetails(tripCities.get(0),tripCities.get(tripCities.size()-1));
            return new AirTrip(tripName,tripDuration,tripCities,tripDetails);
        } else{
            Map<String,String> tripDetails = LandTrip.createDetails();
            return new LandTrip(tripName,tripDuration,tripCities,tripDetails);
        }

    }


    //Show all the trips stored in the database
    public void showAllTrips(){
        this.dbManager.showAllTrips();
    }
}
