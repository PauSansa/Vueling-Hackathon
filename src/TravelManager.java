import java.util.*;

public class TravelManager {
    private DbManager dbManager;

    public TravelManager() {
        dbManager = new DbManager();
    }


    //Adds 6 sample trips to the travels list
    @Deprecated
    public void addSampleTrips(){


        List<Trip> sampleTrips = new ArrayList<>(){{
            add(new AirTrip("Resort Trip", 3, Arrays.asList("Madrid","Hawai","Madrid"), AirTrip.createDetails("Madrid", "09:00","Madrid", "15:00") ));
            add(new LandTrip("Discover Americas", 4, Arrays.asList("Tampa","Madrid","Kansas"), LandTrip.createDetails("Tampa Hotel", "2")));
            add(new AirTrip("AMAZING", 5, Arrays.asList("Amazonas","Tampa"), AirTrip.createDetails("Amazonas", "09:00","Tampa", "15:00") ));
            add(new LandTrip("BUCCANERS", 3, Arrays.asList("Tampa","Hawai","Madrid"), LandTrip.createDetails("NFL BUCS OFFICIAL HOTEL", "4") ));
            add(new AirTrip("CHIEFS", 2, Arrays.asList("Kansas City","Huston"), AirTrip.createDetails("Kansas City", "09:00","Huston", "15:00") ));

        }};

        dbManager.insertTrip(sampleTrips.get(0));
    }

    //It returns a list of trips that contain the received city
    public void searchTripCity(){
        String query = null;
        boolean correct = false;
        List<Trip> matches;
        while(!correct) {
            try {
                String keyphrase = Entrys.stringEntry("Enter the city of the flight. EX: Madrid");
                if (keyphrase.length() < 3) {
                    throw new WrongInputException();
                } else {
                    query = keyphrase;
                    correct = true;
                }
            } catch (WrongInputException e) {
                System.out.println("Wrong Input, you must enter 3 chars minimum");
            }
        }
        String finalQuery = query;



    }

    public void searchTripName(){
        String query = null;
        boolean correct = false;
        List<Trip> matches;
        while(!correct) {
            try {
                String keyphrase = Entrys.stringEntry("Enter the name of the flight. EX: Madrid");
                if (keyphrase.length() < 0) {
                    throw new WrongInputException();
                } else {
                    query = keyphrase;
                    correct = true;
                }
            } catch (WrongInputException e) {
                System.out.println("Wrong Input, you must enter a String");
            }
        }
        String finalQuery = query;


    }

    //It deletes a trip if exists using the name of the trip as a parameter
    public void deleteTrip(){
        String tripName = Entrys.stringEntry("Enter the name of the trip to delete:");

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
            System.out.println("The trips has been added to the database");
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
}
