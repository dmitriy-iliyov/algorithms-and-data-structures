package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        int numberOfOperations = 100;

        CountDownLatch latch = new CountDownLatch(numberOfOperations);

        CircularBuffer<String> firstCircularBuffer = new CircularBuffer<>(10);
        CircularBuffer<String> secondCircularBuffer = new CircularBuffer<>(numberOfOperations);

        List <Thread> inPutThreads = new ArrayList<>();
        for(int i = 1; i < 6; i++)
            inPutThreads.add(new InPutThread(i, numberOfOperations/5, firstCircularBuffer, latch));
        for (Thread thread : inPutThreads){
            thread.setDaemon(true);
            thread.start();
        }

        List <Thread> outPutThreads = new ArrayList<>();
        for(int i = 1; i < 3; i++)
            outPutThreads.add(new OutPutThread(i, numberOfOperations/2, firstCircularBuffer, secondCircularBuffer, latch));
        for (Thread thread : outPutThreads){
            thread.setDaemon(true);
            thread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < numberOfOperations; i++){
            System.out.println(i + " " + secondCircularBuffer.putOut());
        }
    }
}

class InPutThread extends Thread {
    private int number;
    private int count;
    private CircularBuffer<String> circularBuffer;
    public InPutThread(int number, int count, CircularBuffer<String> circularBuffer, CountDownLatch latch){
        this.number = number;
        this.count = count;
        this.circularBuffer = circularBuffer;
    }

    @Override
    public void run(){
        for(int i = 0; i < this.count;){
            if(circularBuffer.putIn("Потік № " + this.number + " згенерував повідомлення..."))
                i++;
        }
    }
}

class OutPutThread extends Thread {
    private int number;
    private int count;
    private CircularBuffer<String> from;
    private CircularBuffer<String> to;
    private CountDownLatch latch;
    public OutPutThread(int number, int count, CircularBuffer<String> from, CircularBuffer<String> to, CountDownLatch latch){
        this.number = number;
        this.count = count;
        this.from = from;
        this.to = to;
        this.latch = latch;
    }

    @Override
    public void run(){
        for(int i = 0; i < this.count;){
            String data = from.putOut();
            if(data != null){
                to.putIn("Потік № " + this.number + " переклав повідомлення : \" " + data + " \".");
                latch.countDown();
            }
        }
    }
}