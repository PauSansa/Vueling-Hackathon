import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//SuperClass of AirTrip and LandTrip, it decides the structure of those
public abstract class Trip {
    private String name;
    private String type;
    private int duration;
    private List<String> cities;
    private Map<String, String> details;

    public Trip(String name, String type, int duration,List<String> cities, Map<String, String> details) {
        this.name = name;
        this.type = type;
        this.cities = cities;
        this.duration = duration;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getCities() {
        return cities;
    }

    public Map<String, String> getDetails() {
        return details;
    }


    //A trip will be equal to another if their names are equal
    @Override
    public boolean equals(Object obj) {
        Trip other = (Trip) obj;
        if(this.name.equals(other.getName())){
            return true;
        } else{
            return false;
        }
    }

    //It converts cities and details onto a more readable format and return all the atributes of trip
    @Override
    public String toString() {
        String citiesString = String.join(", ", this.cities);
        String detailsString = this.details.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining(", "));
        return String.join("; ", this.name, this.type + "Trip", citiesString, detailsString);
    }
}
