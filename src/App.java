public class App {
    private TravelManager travelManager;

    public App(){
        this.travelManager = new TravelManager();
    }

    public void init() {
        System.out.println("Starting App...");
        loopManager();

    }

    public void loopSearch(){
        boolean loop = true;
        while(loop) {
            System.out.println();
            int opt = menuSearch();
            switch (opt){
                case 1:
                    this.travelManager.searchTrip();
                    break;
                case 2:
                    loop = false;
                    loopManager();
                    break;
            }
        }
    }

    public int menuSearch(){
        System.out.println("~~~~~~~ SEARCH MENU ~~~~~~~");
        System.out.println("~~1. Search a Trip~~");
        System.out.println("~~2. Go to Manager Menu~~");
        return Entrys.intEntry("Select Option (Enter a digit)");
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
                    this.travelManager.deleteTrip();
                    break;
                case 3:
                    this.travelManager.addSampleTrips();
                    break;
                case 4:
                    loop = false;
                    loopSearch();
                    break;

            }
        }
    }

    public int menuManager() {
        System.out.println("~~~~~~~ MANAGER MENU ~~~~~~~");
        System.out.println("~~1. Add a new Trip~~");
        System.out.println("~~2. Delete a new Trip~~");
        System.out.println("~~3. Add sample trips~~");
        System.out.println("~~4. Go to Trip Search Engine~~");
        return Entrys.intEntry("Select Option (Enter a digit)");
    }

}
