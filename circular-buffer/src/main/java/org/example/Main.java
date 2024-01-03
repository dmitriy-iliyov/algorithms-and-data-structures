package org.example;

public class Main {
    public static void main(String[] args) {
        CircularBuffer<Integer> circularBuffer = new CircularBuffer<>(3);
        circularBuffer.putIn(1);
        circularBuffer.putIn(4);
        circularBuffer.putIn(3);
        for(int i = 0; i < 3; i++){
            System.out.println(circularBuffer.putOut());
        }
    }
}