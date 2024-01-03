package org.example;

import java.util.ArrayList;
import java.util.List;

public class CircularBuffer<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private List <T> data;
    private volatile int readSequenceCounter;
    private volatile int writeSequenceCounter;
    public CircularBuffer(int capacity){
        this.capacity = (capacity < 1) ? DEFAULT_CAPACITY : capacity;
        this.data = new ArrayList<>(this.capacity);
        this.readSequenceCounter = 0;
        this.writeSequenceCounter = -1;
    }

    public void putIn(T element){
        if((writeSequenceCounter - readSequenceCounter) + 1 != this.capacity){
            data.add(++writeSequenceCounter % capacity, element);
        }
    }

    public T putOut(){
        T element = null;
        boolean isBufferEmpty = writeSequenceCounter < readSequenceCounter;
        if(!isBufferEmpty)
            element = data.get(readSequenceCounter++ % capacity);
        return element;
    }
}
