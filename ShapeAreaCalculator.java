// 2.	Write a program in Java to calculate the area of different shapes using polymorphism and inheritance.

import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();

    public void displayArea() {
        System.out.printf("Area: %.2f\n", calculateArea());
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

class Rhombus extends Shape {
    private final double diagonal1;
    private final double diagonal2;

    public Rhombus(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double calculateArea() {
        return (diagonal1 * diagonal2) / 2;
    }
}

class Parallelogram extends Shape {
    private final double base;
    private final double height;

    public Parallelogram(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }
}

class Trapezium extends Shape {
    private final double base1;
    private final double base2;
    private final double height;

    public Trapezium(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }
}

class EquilateralTriangle extends Shape {
    private final double side;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return (Math.sqrt(3) / 4) * side * side;
    }
}

class Sector extends Shape {
    private final double radius;
    private final double angle; // in degrees

    public Sector(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * radius * radius) * (angle / 360);
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nShape Area Calculator");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Rhombus");
            System.out.println("5. Parallelogram");
            System.out.println("6. Trapezium");
            System.out.println("7. Equilateral Triangle");
            System.out.println("8. Sector");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            Shape shape = null;

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter radius: ");
                    shape = new Circle(scanner.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    shape = new Rectangle(length, scanner.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    shape = new Triangle(base, scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Enter first diagonal: ");
                    double d1 = scanner.nextDouble();
                    System.out.print("Enter second diagonal: ");
                    shape = new Rhombus(d1, scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Enter base: ");
                    double pBase = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    shape = new Parallelogram(pBase, scanner.nextDouble());
                }
                case 6 -> {
                    System.out.print("Enter first base: ");
                    double b1 = scanner.nextDouble();
                    System.out.print("Enter second base: ");
                    double b2 = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    shape = new Trapezium(b1, b2, scanner.nextDouble());
                }
                case 7 -> {
                    System.out.print("Enter side length: ");
                    shape = new EquilateralTriangle(scanner.nextDouble());
                }
                case 8 -> {
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    System.out.print("Enter angle (degrees): ");
                    shape = new Sector(radius, scanner.nextDouble());
                }
                case 9 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice! Please try again.");
            }

            if(shape != null) {
                shape.displayArea();
            }

        } while(choice != 9);

        scanner.close();
    }
}