public class App {
    private TravelManager travelManager;

    public App(){
        this.travelManager = new TravelManager();
    }

    public void init() {
        System.out.println("Starting App...");
        loopManager();

    }


    //This method gestionates the loop of the Search Menu, at each iteration invokes the menuSearch() that returns
    //an int depending on the choice of the costumer
    public void loopSearch(){
        boolean loop = true;
        while(loop) {
            System.out.println();
            int opt = menuSearch();
            switch (opt){
                case 1:
                    this.travelManager.searchTripCity();
                    break;
                case 2:
                    this.travelManager.searchTripName();
                case 3:
                    loop = false;
                    loopManager();
                    break;
            }
        }
    }

    //This method asks the costumer for an option to execute
    public int menuSearch(){
        System.out.println("~~~~~~~ SEARCH MENU ~~~~~~~");
        System.out.println("~~1. Search a Trip by City~~");
        System.out.println("~~2. Search a Trip by Name~~");
        System.out.println("~~3. Go to Manager Menu~~");
        return Entrys.intEntry("Select Option (Enter a digit)");
    }


    //This method gestionates the loop of the Trip Manager, at each iteration invokes the menuManager() that returns
    //an int depending on the choice of the costumer
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
                    this.travelManager.showAllTrips();
                    break;
                case 4:
                    loop = false;
                    loopSearch();
                    break;

            }
        }
    }


    //This method asks the costumer for an option to execute
    public int menuManager() {
        System.out.println("~~~~~~~ MANAGER MENU ~~~~~~~");
        System.out.println("~~1. Add a new Trip~~");
        System.out.println("~~2. Delete a new Trip~~");
        System.out.println("~~3. Show All Trips~~");
        System.out.println("~~4. Go to Trip Search Engine~~");
        return Entrys.intEntry("Select Option (Enter a digit)");
    }

}
