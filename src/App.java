public class App {
    private TravelManager travelManager;

    public App(){
        this.travelManager = new TravelManager();
    }

    public void init() {
        System.out.println("Starting App...");
        loopManager();

    }

    public void loopManager(){
        boolean loop = true;
        while (loop) {
            System.out.println();
            int opt = menuManager();
            switch (opt) {
                case 1:
                    this.travelManager.addTrip();
                    break;
                case 2:

            }
        }
    }

    public int menuManager() {
        System.out.println("~~~~~~~ APP MENU ~~~~~~~");
        System.out.println("~~1. Add a new Trip~~");
        System.out.println("~~2. Delete a new Trip~~");
        System.out.println("~~2. Go to Trip Search Engine~~");
        return Entrys.intEntry("Select Option (Enter a digit)");
    }

}
