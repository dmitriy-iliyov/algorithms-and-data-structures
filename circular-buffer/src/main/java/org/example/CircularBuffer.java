package org.example;


public class CircularBuffer<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private final int size;
    final T [] data;
    private volatile int readIndex;
    private volatile int writeIndex;
    public CircularBuffer(int size){
        this.size = (size < 10) ? DEFAULT_CAPACITY : size;
        this.data = (T []) new Object[this.size];
        this.readIndex = 0;
        this.writeIndex = -1;
    }

    public synchronized boolean putIn(T element){
        if(!((writeIndex - readIndex) + 1 == this.size)){
            int nextWriteSeq = writeIndex + 1;
            data[nextWriteSeq % size] = element;
            writeIndex++;
            return true;
        }
        return false;
    }

    public synchronized T putOut(){
        if(!(writeIndex < readIndex)){
            int currentIndex = readIndex++ % size;
            T element = data[currentIndex];
            data[currentIndex] = null;
            return element;
        }
        return null;
    }
}
