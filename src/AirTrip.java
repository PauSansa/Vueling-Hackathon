import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirTrip extends Trip{
    public AirTrip(String name, int duration,List<String> cities, Map<String, String> details) {
        super(name, "air", duration,cities, details);
    }

    public static Map<String,String> createDetails(String city1, String city2){
        String detailDeparture1city = city1;
        String detailDeparture1hour = Entrys.hourEntry("Enter the hour of the departure from " + detailDeparture1city);

        String detailDeparture2city = city2;
        String detailDeparture2hour = Entrys.hourEntry("Enter the hour of the departure from " + detailDeparture2city);

        Map<String, String> tripDetails = new HashMap<>(){{
            put(detailDeparture1city,detailDeparture1hour);
            put(detailDeparture2city,detailDeparture2hour);
        }};

        return tripDetails;
    }
}
