import java.util.Map;

public class AirTrip extends Trip{
    public AirTrip(String name, int duration, Map<String, String> misc) {
        super(name, "air", duration, misc);
    }
}
