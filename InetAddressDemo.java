// 22.	Write a Java Program to demonstrate inet address.

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 1. Get Local Host information
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host: ");
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());
            System.out.println("Canonical Name: " + localHost.getCanonicalHostName());
            System.out.println();

            // 2. Get information for a specific Host
            String hostName = "www.google.com";
            InetAddress googleHost = InetAddress.getByName(hostName);
            System.out.println("Information for " + hostName + ": ");
            System.out.println("IP Address: " + googleHost.getHostAddress());
            System.out.println("Canonical Name: " + googleHost.getCanonicalHostName());
            System.out.println();

            // 3. Get all IP addresses for a Port
            String multiPHost = "www.facebook.com";
            System.out.println("All IP addresses for " + multiPHost + ":");
            InetAddress[] allIPs = InetAddress.getAllByName(multiPHost);
            for (InetAddress address: allIPs) {
                System.out.println("IP: " + address.getHostAddress());
            }
            System.out.println();

            // 4. Reverse Lookup (IP to hostname)
            String ipAddress = "8.8.8.8";
            InetAddress dnsServer = InetAddress.getByName(ipAddress);
            System.out.println("Reverse lookup for " + ipAddress + ":");
            System.out.println("Host Name: " + dnsServer.getHostName());
            System.out.println("Canonical Name: " + dnsServer.getCanonicalHostName());

        } catch (java.net.UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
