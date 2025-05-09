package com.University;

import com.University.courses.Course;
import com.University.applicants.Applicant;
import com.University.admission.AdmissionProcessor;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityAdmissionSystem {
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final ArrayList<Applicant> applicants = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // Preloaded courses with fixed 60% minimum grade
    static {
        courses.add(new Course("CS101", "Computer Science", 50, 60.0));
        courses.add(new Course("EE201", "Electrical Engineering", 40, 60.0));
        courses.add(new Course("MA301", "Mathematics", 35, 60.0));
        courses.add(new Course("PHY401", "Physics", 30, 60.0));
        courses.add(new Course("CHEM501", "Chemistry", 25, 60.0));
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n==== University Admission System ====");
            System.out.println("1. View All Courses");
            System.out.println("2. Register Applicant");
            System.out.println("3. Process Admissions");
            System.out.println("4. View Applicants");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            int choice = getIntInput(1, 5);

            switch(choice) {
                case 1 -> viewCourses();
                case 2 -> registerApplicant();
                case 3 -> processAdmissions();
                case 4 -> viewApplicants();
                case 5 -> {
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static void viewCourses() {
        System.out.println("\nAvailable Courses:");
        for(Course c : courses) {
            System.out.printf("%s - %s (Capacity: %d/%d, Minimum Grade: 60%%)\n",
                    c.getCourseCode(), c.getCourseName(),
                    c.getEnrolled(), c.getCapacity());
        }
    }

    private static void registerApplicant() {
        System.out.print("\nEnter applicant ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = getDoubleInput(0, 100);

        if(grade < 60) {
            System.out.println("Applicant does not meet minimum grade requirement (60%)");
            return;
        }

        Applicant applicant = new Applicant(id, name, grade);
        selectCourseForApplicant(applicant);
        applicants.add(applicant);
        System.out.println("Applicant registered!");
    }

    private static void selectCourseForApplicant(Applicant applicant) {
        viewCourses();
        System.out.print("Select course (1-" + courses.size() + "): ");
        int choice = getIntInput(1, courses.size());
        applicant.selectCourse(courses.get(choice-1));
    }

    private static void processAdmissions() {
        if(applicants.isEmpty()) {
            System.out.println("\nNo applicants to process!");
            return;
        }

        AdmissionProcessor processor = new AdmissionProcessor();
        int successful = 0;

        for(Applicant a : applicants) {
            if(processor.processApplication(a)) successful++;
        }

        System.out.println("\nProcessed " + applicants.size() + " applications");
        System.out.println("Successful admissions: " + successful);
    }

    private static void viewApplicants() {
        if(applicants.isEmpty()) {
            System.out.println("\nNo applicants registered!");
            return;
        }

        System.out.println("\nRegistered Applicants:");
        for(Applicant a : applicants) {
            System.out.printf("%s - %s (Grade: %.1f%%) - Applied to: %s\n",
                    a.getApplicantId(), a.getName(),
                    a.getGrade(), a.getSelectedCourse().getCourseName());
        }
    }

    private static int getIntInput(int min, int max) {
        while(true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if(input >= min && input <= max) return input;
                System.out.printf("Enter between %d-%d: ", min, max);
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    private static double getDoubleInput(double min, double max) {
        while(true) {
            try {
                double input = Double.parseDouble(scanner.nextLine());
                if(input >= min && input <= max) return input;
                System.out.printf("Enter between %.1f-%.1f: ", min, max);
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}