import java.util.ArrayList;
import java.util.Scanner;

class RailwayEntity {
    protected String name;
    protected String code;

    public RailwayEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void displayInfo() {
        System.out.println("Entity: " + name + " (Code: " + code + ")");
    }

}

// Intermediate Class
class Train extends RailwayEntity {
    protected String route;
    protected int capacity;

    public Train(String name, String code, String route, int capacity) {
        super(name, code);
        this.route = route;
        this.capacity = capacity;
    }

    public void displayCapacity() {
        System.out.println("Capacity: " + capacity + " passengers");
    }
}

class PassengerTrain extends Train {
    private final int numCoaches;
    private final String amenities;

    public PassengerTrain(String name, String code, String route, int capacity,
                          int numCoaches, String amenities) {
        super(name, code, route, capacity);
        this.numCoaches = numCoaches;
        this.amenities = amenities;
    }

    public void bookTicket() {
        System.out.println("Ticket booked for " + name + " (" + code + ")");
    }

    public void displayAmenities() {
        System.out.println("Amenities: " + amenities);
    }

    // Added getter methods for private fields
    public int getNumCoaches() {
        return numCoaches;
    }

}

public class RailwayManagementSystem {
    private static final ArrayList<PassengerTrain> trains = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize with some trains
        trains.add(new PassengerTrain("Express 2023", "EXP-2023",
                "Mumbai-Delhi", 500, 20, "AC, WiFi, Pantry"));

        trains.add(new PassengerTrain("Superfast", "SF-456",
                "Chennai-Kolkata", 450, 18, "AC, Charging Points"));

        trains.add(new PassengerTrain("Local Commuter", "LC-789",
                "Bangalore Suburban", 800, 15, "Standard Seating"));

        while(true) {
            System.out.println("\n==== Railway Management System ====");
            System.out.println("1. View All Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Show Train Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int choice = getIntInput(1, 4);

            switch(choice) {
                case 1 -> viewAllTrains();
                case 2 -> bookTicket();
                case 3 -> showTrainDetails();
                case 4 -> {
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static void viewAllTrains() {
        System.out.println("\nAvailable Trains:");
        for(int i = 0; i < trains.size(); i++) {
            System.out.println((i+1) + ". " + trains.get(i).name + " (" + trains.get(i).code + ")");
        }
    }

    private static void bookTicket() {
        viewAllTrains();
        System.out.print("Select train to book: ");
        int index = getIntInput(1, trains.size()) - 1;
        trains.get(index).bookTicket();
    }

    private static void showTrainDetails() {
        viewAllTrains();
        System.out.print("Select train to view details: ");
        int index = getIntInput(1, trains.size()) - 1;

        PassengerTrain train = trains.get(index);
        System.out.println("\n===== Train Details =====");
        train.displayInfo();
        train.displayCapacity();
        train.displayAmenities();
        System.out.println("Route: " + train.route);
        System.out.println("Coaches: " + train.getNumCoaches());  // Using getter instead of direct access
    }

    private static int getIntInput(int min, int max) {
        while(true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if(input >= min && input <= max) return input;
                System.out.printf("Please enter between %d-%d: ", min, max);
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}