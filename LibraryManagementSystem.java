/*
4.	Write a program in Java for Library management using Multilevel inheritance with at least 3 classes all classes
must have two-member variable and two -member method.
 */

import java.util.ArrayList;
import java.util.Scanner;

class LibraryItem {
    protected String title;
    protected boolean isAvailable;

    public LibraryItem(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " checked out successfully");
        } else {
            System.out.println(title + " is already checked out");
        }
    }

    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " returned successfully");
        }
        else {
            System.out.println(title + " was not checked out");
        }
    }
}

class Book extends LibraryItem {
    protected String author;
    public Book(String title, String author) {
        super(title);
        this.author = author;
    }
    public void displayInfo() {
        System.out.println(title);
        System.out.println("Author: " + author);
    }
}

class ComputerScienceBook extends Book {
    private final String specialization;
    private final int edition;
    private final String isbn;
    public ComputerScienceBook(String title, String author, String isbn,
                               String specialization, int edition) {
        super(title, author);
        this.specialization = specialization;
        this.edition = edition;
        this.isbn = isbn;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Edition: " + edition);
        System.out.println("ISBN: " + isbn);
    }
}

public class LibraryManagementSystem {
    private static final ArrayList<LibraryItem> library = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        library.add(new ComputerScienceBook(
                "Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow: Concepts, Tools, and Techniques to Build Intelligent Systems, Third Edition",
                "Aurélien Géron",
                "1098125975",
                "Machine Learning",
                3
        ));

        library.add(new ComputerScienceBook(
                "Data Science From Scratch",
                "Joel Grus",
                "1492041130",
                "Data Science",
                2
        ));

        library.add(new ComputerScienceBook(
                "Python Data Science Handbook",
                "Jake VanderPlas",
                "1098121228",
                "Data Science",
                2
        ));

        library.add(new ComputerScienceBook(
                "SQL, PL/SQL, The programming language of Oracle",
                "Ivan Bayross",
                "8176560724",
                "Databases",
                1
        ));

        library.add(new ComputerScienceBook(
                "Digital Image Processing",
                "Rafael C. Gonzalez, Richard E. Woods",
                "9353062983",
                "Image Processing",
                4
        ));

        library.add(new ComputerScienceBook(
                "Let Us C",
                "Yashavant Kanetkar",
                "8183331637",
                "Programming",
                16
        ));

        library.add(new ComputerScienceBook(
                "Data Structures using C",
                "Reema Thareja",
                "0198099304",
                "Data Structures",
                2
        ));

        library.add(new ComputerScienceBook(
                "Computer Organization and Architecture",
                "William Stallings",
                "1292096853",
                "Computer Architecture",
                10
        ));

        library.add(new ComputerScienceBook(
                "An Introduction to Formal Languages and Automata",
                "Peter Linz",
                "1284077241",
                "Formal Languages",
                6
        ));

        library.add(new ComputerScienceBook(
                "Operating System Concepts",
                "Abraham Silberschatz, Peter B. Galvin, Greg Gagne",
                "1119800366",
                "Operating Systems",
                10
        ));

        library.add(new ComputerScienceBook(
                "Data Communication and Networking",
                "Behrouz A. Forouzan",
                "0073376221",
                "Networking",
                5
        ));

        library.add(new ComputerScienceBook(
                "Discrete Mathematics",
                "Kenneth H. Rosen",
                "125967651X",
                "Mathematics",
                7
        ));

        library.add(new ComputerScienceBook(
                "Java: The Complete Reference",
                "Herbert Schildt",
                "1260440230",
                "Programming",
                11
        ));

        while (true) {
            System.out.println("\n===== Computer Science Library =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Check Out Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int choice = getIntInput(1, 4);

            System.out.println();

            switch (choice) {
                case 1 -> displayBooks();
                case 2 -> checkOutBook();
                case 3 -> returnBook();
                case 4 -> {
                    System.out.println("Exiting Program....");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static void displayBooks() {
        System.out.println("\nAvailable Computer Science Books:\n");
        for (int i = 0; i < library.size(); i++) {
            LibraryItem item = library.get(i);
            System.out.print((i+1) + ". ");

            if (item instanceof ComputerScienceBook csb) {
                csb.displayInfo();
                System.out.println("Status: " + (csb.isAvailable ? "Available" : "Checked Out"));
            }
            System.out.println("----------------------");
        }
    }

    private static void checkOutBook() {
        viewAllBooksInBrief();
        System.out.print("\nEnter book number to check out: ");
        int index = getIntInput(1, library.size()) - 1;
        library.get(index).checkOut();
    }

    private static void returnBook() {
        viewAllBooksInBrief();
        System.out.print("\nEnter book number to return: ");
        int index = getIntInput(1, library.size()) - 1;
        LibraryItem item = library.get(index);

        if (!item.isAvailable) {  // Additional check in UI
            item.returnItem();
        } else {
            System.out.println("This book wasn't checked out!");
        }
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
                System.out.printf("Please enter between %d-%d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    private static void viewAllBooksInBrief() {
        for (int i = 0; i < library.size(); i++) {
            LibraryItem item = library.get(i);
            String status = item.isAvailable ? "Available" : "Unavailable";
            System.out.println((i+1) + ". " + item.title + "\n   Status: " + status);
        }
    }
}