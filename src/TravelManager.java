import java.util.*;

public class TravelManager {
    private List<Trip> travels;

    public TravelManager() {
        this.travels = new ArrayList<>();
    }

    public void deleteTrip(){
        String tripName = Entrys.stringEntry("Enter the name of the trip to delete:");
        ListIterator<Trip> lt = travels.listIterator();
        while(lt.hasNext()){
            Trip t = lt.next();
            if (t.getName().equals(tripName)){
                lt.remove();
            }
        }
    }


    //Creates a trip using method createTrip(), and, if not exists, it adds it to the travels list
    public void addTrip() {
        int tripType;
        Trip trip = null;
        boolean correct = false;
        boolean tripExists;

        System.out.println("Its an AirTrip(1) or an LandTrip(2) ??");

        try {
            tripType = Entrys.intEntry("Select 1 or 2");
            if (tripType == 1 || tripType == 2){
                trip = createTrip(tripType);
            } else{
                throw new WrongInputException();
            }
        } catch (WrongInputException e){
            System.out.println("Wrong input, you have to enter 1 or 2 ");
        }

        for (Trip t : travels){
            if (t.equals(trip)){
                System.out.println("This trip already exists");
                return;
            }
        }

        this.travels.add(trip);
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
