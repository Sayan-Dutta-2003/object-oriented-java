// 24.	Write a Java Program to demonstrate URL.

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String inputURL = sc.nextLine();

        try {
            URL url = new URL(inputURL);

            // Display URL components
            System.out.println("=== URL Breakdown ===");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Default Port: " + url.getDefaultPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("User Info: " + url.getUserInfo());

        } catch (MalformedURLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
