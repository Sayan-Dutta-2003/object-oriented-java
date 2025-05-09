/*
1.	Write a program in Java for a shipping database using multilevel inheritance with at least 3 classes.
All classes must have two member variables and a two-member method.
 */

import java.util.Scanner;
import java.util.ArrayList;

class shipment{
    protected String shipmentId;
    protected String destination;

    public shipment(String shipmentId, String destination) {
        this.shipmentId = shipmentId;
        this.destination = destination;
    }

    public void trackShipment() {
        System.out.println("Tracking shipment ID: " + shipmentId + " heading to " + destination);
    }

    public void updateDestination(String newDestination) {
        this.destination = newDestination;
        System.out.println("Destination updated for shipment " + shipmentId);
    }
}

class cargo extends shipment {

    protected double cargoWeight;
    protected String cargoType;

    public cargo(String shipmentId, String destination, double cargoWeight, String cargoType) {
        super(shipmentId, destination);
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public double calculateShippingCost() {
        return cargoWeight * 2.5;
    }

    public void displayCargoInfo() {
        System.out.println("Cargo Type: " + cargoType + ", Weight: " + cargoWeight + " kg");
    }

    public void updateCargoType(String newType) {
        this.cargoType = newType;
    }

    public void updateCargoWeight(double newWeight) {
        this.cargoWeight = newWeight;
    }
}

class container extends cargo {
    private String containerNumber;
    private String containerSize;

    public container(String shipmentId, String destination, double cargoWeight, String cargoType, String containerNumber, String containerSize) {
        super(shipmentId, destination, cargoWeight, cargoType);
        this.containerNumber = containerNumber;
        this.containerSize = containerSize;
    }

    public void assignContainer(String number, String size) {
        this.containerNumber = number;
        this.containerSize = size;
    }
    public void displayContainerDetails() {
        System.out.println("Container: " + containerNumber + " (" + containerSize + ")");
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public String getContainerSize() {
        return containerSize;
    }
    
}

public class ShippingDatabase {
    private static final ArrayList<container> shipments = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while(running) {
            System.out.println("\n===== Shipping Database Menu =====");
            System.out.println("1. Add New Shipment");
            System.out.println("2. View All Shipments");
            System.out.println("3. Update destination");
            System.out.println("4. Update cargo details");
            System.out.println("5. Update container details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = getIntInput(6);

            switch (choice) {
                case 1 -> addNewShipment();
                case 2 -> viewAllShipments();
                case 3 -> updateShipmentDestination();
                case 4 -> updateCargoDetails();
                case 5 -> updateContainerDetails();
                case 6 -> running = confirmExit();
            }
        }
        System.out.println("Program exited. Thank you!");
        sc.close();
    }

    private static void addNewShipment() {
        System.out.println("\n=== Enter New Shipment Details ===");

        String shipmentId;
        while(true) {
            System.out.print("Shipment ID: ");
            shipmentId = sc.nextLine().trim();

            if(shipmentId.isEmpty()) {
                System.out.println("Error: Shipment ID cannot be empty!");
                continue;
            }

            if(isShipmentIdExists(shipmentId)) {
                System.out.println("Error: Shipment ID already exists!");
            } else {
                break;
            }
        }
        System.out.print("Destination: ");
        String destination = sc.nextLine();

        System.out.print("Cargo Weight (kg): ");
        double cargoWeight = getDoubleInput();

        System.out.print("Cargo Type: ");
        String cargoType = sc.nextLine();

        System.out.print("Container Number: ");
        String containerNumber = sc.nextLine();

        System.out.print("Container Size: ");
        String containerSize = sc.nextLine();

        container newContainer = new container(shipmentId, destination, cargoWeight,
                cargoType, containerNumber, containerSize);
        shipments.add(newContainer);

        System.out.println("\nShipment added successfully!");
    }

    private static boolean isShipmentIdExists(String id) {
        for(container container : shipments) {
            if(container.shipmentId.equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private static void viewAllShipments() {
        if(shipments.isEmpty()) {
            System.out.println("\nNo shipments found!");
            return;
        }

        System.out.println("\n=== All Shipments ===");
        for(int i = 0; i < shipments.size(); i++) {
            System.out.println("\nShipment #" + (i+1));
            container container = shipments.get(i);
            container.trackShipment();
            container.displayCargoInfo();
            System.out.printf("Shipping Cost: $%.2f%n", container.calculateShippingCost());
            container.displayContainerDetails();
            System.out.println("----------------------");
        }
    }

    // Update Shipment details
    private static void updateShipmentDestination() {
        if(shipments.isEmpty()) {
            System.out.println("\nNo shipments available to update!");
            return;
        }

        System.out.println("\n=== Update Destination ===");
        viewAllShipmentsBrief();
        System.out.print("Enter shipment number to update: ");
        int index = getIntInput(shipments.size()) - 1;

        System.out.print("Enter new destination: ");
        String newDest = sc.nextLine();

        shipments.get(index).updateDestination(newDest);
        System.out.println("Destination updated successfully!");
    }

    // Update Cargo details
    private static void updateCargoDetails() {
        if(shipments.isEmpty()) {
            System.out.println("\nNo shipments available to update!");
            return;
        }

        System.out.println("\n=== Update Cargo Details ===");
        viewAllShipmentsBrief();
        System.out.print("Enter shipment number to update: ");
        int index = getIntInput(shipments.size()) - 1;

        System.out.print("Enter new cargo weight (kg): ");
        double newWeight = getDoubleInput();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter new cargo type: ");
        String newType = sc.nextLine();

        container container = shipments.get(index);
        container.updateCargoWeight(newWeight);
        container.updateCargoType(newType);
        System.out.println("Cargo details updated successfully!");
    }

    // Update Container Details
    private static void updateContainerDetails() {
        if(shipments.isEmpty()) {
            System.out.println("\nNo shipments available to update!");
            return;
        }

        System.out.println("\n=== Update Container Details ===");
        viewAllShipmentsBrief();
        System.out.print("Enter shipment number to update: ");
        int index = getIntInput(shipments.size()) - 1;

        System.out.print("Enter new container number: ");
        String newNumber = sc.nextLine();

        System.out.print("Enter new container size: ");
        String newSize = sc.nextLine();

        shipments.get(index).assignContainer(newNumber, newSize);
        System.out.println("Container details updated successfully!");
    }

    private static boolean confirmExit() {
        System.out.print("\nAre you sure you want to exit? (yes/no): ");
        String answer = sc.nextLine();
        return !answer.equalsIgnoreCase("yes");
    }

    // Input validation methods
    private static int getIntInput(int max) {
        while(true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if(input >= 1 && input <= max) return input;
                System.out.printf("Please enter a number between %d and %d: ", 1, max);
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static double getDoubleInput() {
        while(true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static void viewAllShipmentsBrief() {
        for(int i = 0; i < shipments.size(); i++) {
            container c = shipments.get(i);
            System.out.println("Shipment #" + (i+1) +
                    " - ID: " + c.shipmentId +
                    " | Container: " + c.getContainerNumber() +
                    " (" + c.getContainerSize() + ")");
        }
    }
}
