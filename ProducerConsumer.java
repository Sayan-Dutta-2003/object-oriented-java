// 15.	Write a program in Java to implement producer-consumer program using inter-thread communication.

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer Interrupted");
        }
        System.out.println("Producer finished");

    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++) {
                Integer item = sharedQueue.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
        System.out.println("Consumer finished");
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        producerThread.join();
        consumerThread.join();

        System.out.println("All tasks completed");
    }
}
