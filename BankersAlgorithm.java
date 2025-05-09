// 16.	Write a program in Java to implement banker-algorithm in order to prevent deadlock.

import java.util.Scanner;

public class BankersAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get system configuration
        System.out.print("Enter number of processes: ");
        int numProcesses = sc.nextInt();
        System.out.print("Enter number of resources: ");
        int numResources = sc.nextInt();

        // Initialize matrices and vectors
        int[][] max = new int[numProcesses][numResources];
        int[][] allocation = new int[numProcesses][numResources];
        int[] totalResources = new int[numResources];
        int[][] need = new int[numProcesses][numResources];
        boolean[] finish = new boolean[numProcesses];

        // Read maximum matrix
        System.out.println("\nEnter MAX matrix:");
        for(int i=0; i<numProcesses; i++) {
            System.out.print("Process P" + i + ": ");
            for(int j=0; j<numResources; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        // Read allocation matrix
        System.out.println("\nEnter ALLOCATION matrix:");
        for(int i=0; i<numProcesses; i++) {
            System.out.print("Process P" + i + ": ");
            for(int j=0; j<numResources; j++) {
                allocation[i][j] = sc.nextInt();
                if(allocation[i][j] > max[i][j]) {
                    System.out.println("Error: Allocation exceeds maximum claim!");
                    return;
                }
            }
        }

        // Read total system resources
        System.out.print("\nEnter TOTAL system resources: ");
        for(int j=0; j<numResources; j++) {
            totalResources[j] = sc.nextInt();
        }

        // Calculate available resources
        int[] available = new int[numResources];
        for(int j=0; j<numResources; j++) {
            int allocatedSum = 0;
            for(int i=0; i<numProcesses; i++) {
                allocatedSum += allocation[i][j];
            }
            available[j] = totalResources[j] - allocatedSum;
            if(available[j] < 0) {
                System.out.println("Error: Total resources exceeded by allocations!");
                return;
            }
        }

        // Calculate need matrix
        for(int i=0; i<numProcesses; i++) {
            for(int j=0; j<numResources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        // Safety algorithm
        int[] work = available.clone();
        int[] safeSequence = new int[numProcesses];
        int count = 0;

        while(count < numProcesses) {
            boolean found = false;
            for(int i=0; i<numProcesses; i++) {
                if(!finish[i] && isNeedLessThanWork(need[i], work)) {
                    // Add allocation to work
                    for(int j=0; j<numResources; j++) {
                        work[j] += allocation[i][j];
                    }
                    safeSequence[count] = i;
                    finish[i] = true;
                    count++;
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("\nSystem is in unsafe state!");
                return;
            }
        }

        // Print safe sequence
        System.out.println("\nSystem is in safe state!");
        System.out.print("Safe sequence: ");
        for(int i=0; i<numProcesses; i++) {
            System.out.print("P" + safeSequence[i]);
            if(i != numProcesses-1) System.out.print(" -> ");
        }
        System.out.println();
    }

    private static boolean isNeedLessThanWork(int[] need, int[] work) {
        for(int j=0; j<need.length; j++) {
            if(need[j] > work[j]) {
                return false;
            }
        }
        return true;
    }
}