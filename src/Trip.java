import java.util.List;
import java.util.Map;

public abstract class Trip {
    private String name;
    private String type;
    private int duration;
    private List<String> cities;
    private Map<String, String> details;

    public Trip(String name, String type, int duration,List<String> cities, Map<String, String> details) {
        this.name = name;
        this.type = type;
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

    @Override
    public boolean equals(Object obj) {
        Trip other = (Trip) obj;
        if(this.name.equals(other.getName())){
            return true;
        } else{
            return false;
        }
    }
}
