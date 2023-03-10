import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LandTrip extends Trip{
    public LandTrip(String name, int duration, List<String> cities, Map<String, String> details) {
        super(name, "Land", duration, cities, details);
    }

    //Static method to agilize the process of creating the manual trip
    public static Map<String,String> createDetails(){
        String hotel = Entrys.stringEntry("Enter the name of the hotel");
        String score = Entrys.scoreEntry("Enter the stars of the hotel") + " *";

        Map<String,String> tripDetails = new HashMap<>(){{
            put(hotel,score);
        }};

        return tripDetails;
    }


    //Static method to agilize the process of creating sample trips
    public static Map<String,String> createDetails(String hotel, String score){
        Map<String,String> tripDetails = new HashMap<>(){{
            put(hotel,score);
        }};

        return tripDetails;
    }
}
