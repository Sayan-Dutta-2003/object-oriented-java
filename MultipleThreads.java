// 13.	Write a program in Java to create multiple threads.

import java.util.Scanner;

public class MultipleThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many threads you want run?: ");
        int total = sc.nextInt();
        for (int i = 1; i <= total; i++) {
            Thread thread = new Thread(new MyRunnable(i));
                thread.start();

        }
    }
}

class MyRunnable implements Runnable {

    private final int threadId;

    public MyRunnable(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadId + " is running");
        try {
//            Thread.sleep(2000);
            Thread.sleep(1000L * threadId); // // Sleeps 1s, 2s, 3s respectively
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadId + " completed");
    }
}