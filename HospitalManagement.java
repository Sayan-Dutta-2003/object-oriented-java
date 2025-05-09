import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Patient extends Person {
    protected String diagnosis;
    protected String attendingDoctor;

    public Patient(String name, int age, String diagnosis, String attendingDoctor) {
        super(name, age);
        this.diagnosis = diagnosis;
        this.attendingDoctor = attendingDoctor;
    }

    public void updateDiagnosis(String newDiagnosis) {
        this.diagnosis = newDiagnosis;
        System.out.println("Diagnosis updated for " + name);
    }

    public void displayMedicalInformation() {
        System.out.println("Diagnosis: " + diagnosis + ", Doctor: " + attendingDoctor);
    }
}

class InPatient extends Patient {
    private final String admissionDate;
    private int roomNumber;

    public InPatient(String name, int age, String diagnosis, String attendingDoctor,
                     String admissionDate, int roomNumber) {
        super(name, age, diagnosis, attendingDoctor);
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
    }

    public void assignRoom(int newRoom) {
        this.roomNumber = newRoom;
        System.out.println("Room assigned for " + name);
    }

    public void displayAdmissionDetails() {
        System.out.println("Admission Date: " + admissionDate + ", Room: " + roomNumber);
    }
}

public class HospitalManagement {
    private static final ArrayList<InPatient> patients = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while(running) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Admit New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Diagnosis");
            System.out.println("4. Assign New Room");
            System.out.println("5. Discharge Patient");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = getIntInput(1, 6);

            switch(choice) {
                case 1 -> admitPatient();
                case 2 -> viewAllPatients();
                case 3 -> updateDiagnosis();
                case 4 -> assignNewRoom();
                case 5 -> dischargePatient();
                case 6 -> running = confirmExit();
            }
        }
        System.out.println("Program exited. Thank you!");
        sc.close();
    }

    private static void admitPatient() {
        System.out.println("\n=== New Patient Admission ===");

        System.out.print("Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = getIntInput(0, 120);

        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();

        System.out.print("Attending Doctor (Dr.): ");
        String doctor = sc.nextLine();

        System.out.print("Admission Date (DD/MM/YYYY): ");
        String date = getValidDate();

        System.out.print("Room Number: ");
        int room = getIntInput(1, 1000);

        patients.add(new InPatient(name, age, diagnosis, doctor, date, room));
        System.out.println("Patient admitted successfully!");
    }

    private static void viewAllPatients() {
        if(patients.isEmpty()) {
            System.out.println("\nNo patients in records!");
            return;
        }

        System.out.println("\n=== Patient Records ===");
        for(int i = 0; i < patients.size(); i++) {
            System.out.println("\nPatient #" + (i+1));
            InPatient patient = patients.get(i);
            patient.displayDetails();
            patient.displayMedicalInformation();
            patient.displayAdmissionDetails();
            System.out.println("----------------------");
        }
    }

    private static void updateDiagnosis() {
        if(patients.isEmpty()) {
            System.out.println("\nNo patients available!");
            return;
        }

        System.out.println("\n=== Update Diagnosis ===");
        viewBriefList();
        System.out.print("Enter patient number to update: ");
        int index = getIntInput(1, patients.size()) - 1;

        System.out.print("Enter new diagnosis: ");
        String newDiagnosis = sc.nextLine();

        patients.get(index).updateDiagnosis(newDiagnosis);
    }

    private static void assignNewRoom() {
        if(patients.isEmpty()) {
            System.out.println("\nNo patients available!");
            return;
        }

        System.out.println("\n=== Assign New Room ===");
        viewBriefList();
        System.out.print("Enter patient number to update: ");
        int index = getIntInput(1, patients.size()) - 1;

        System.out.print("Enter new room number: ");
        int newRoom = getIntInput(1, 1000);

        patients.get(index).assignRoom(newRoom);
    }

    private static void dischargePatient() {
        if(patients.isEmpty()) {
            System.out.println("\nNo patients available!");
            return;
        }

        System.out.println("\n=== Discharge Patient ===");
        viewBriefList();
        System.out.print("Enter patient number to discharge: ");
        int index = getIntInput(1, patients.size()) - 1;

        InPatient dischargedPatient = patients.remove(index);
        System.out.println("\nPatient " + dischargedPatient.name + " discharged successfully!");
        System.out.println("Discharge Summary:");
        dischargedPatient.displayDetails();
        dischargedPatient.displayMedicalInformation();
        dischargedPatient.displayAdmissionDetails();
    }

    private static boolean confirmExit() {
        System.out.print("\nAre you sure you want to exit? (yes/no): ");
        return !sc.nextLine().equalsIgnoreCase("yes");
    }

    private static int getIntInput(int min, int max) {
        while(true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if(input >= min && input <= max) return input;
                System.out.printf("Please enter between %d-%d: ", min, max);
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    private static void viewBriefList() {
        for(int i = 0; i < patients.size(); i++) {
            System.out.println("Patient #" + (i+1) + ": " + patients.get(i).name);
        }
    }

    private static String getValidDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true) {
            try {
                String dateInput = sc.nextLine();
                LocalDate.parse(dateInput, formatter);
                return dateInput;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please use DD/MM/YYYY format.");
            }
        }
    }
}