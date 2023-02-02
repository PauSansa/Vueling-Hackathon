import java.util.Map;

public abstract class Trip {
    private String name;
    private String type;
    private int duration;
    private Map<String, String> details;

    public Trip(String name, String type, int duration, Map<String, String> details) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.details = details;
    }

    public String generateMsg;
}
