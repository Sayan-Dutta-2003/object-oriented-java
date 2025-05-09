// 14.	Write a program in Java to demonstrate priority assigning to multiple threads.

import java.util.Scanner;

class MyThread extends Thread {
    private final int iterations;

    public MyThread(String name, int iterations) {
        super(name);
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            System.out.println(this.getName());
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of iterations for all threads: ");
        int iterations = sc.nextInt();

        MyThread t1 = new MyThread("Server (Most Important)", iterations);
        MyThread t2 = new MyThread("Text Editor", iterations);
        MyThread t3 = new MyThread("Background Music", iterations);
        MyThread t4 = new MyThread("Printer", iterations);
        MyThread t5 = new MyThread("Video Game", iterations);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        sc.close();
    }
}