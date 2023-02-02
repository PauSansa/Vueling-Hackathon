public class App {
    private TravelManager travelManager;

    public App(){
        this.travelManager = new TravelManager();
        init();
    }

    public void init() {
        System.out.println("Starting App...");

    }

    public void loopManager(){
        boolean loop = true;
        while (loop) {
            int opt = menuManager();
            switch (opt) {
                case 1:
                    this.travelManager.addTrip();

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
