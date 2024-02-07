package org.example;

public class Main {
    public static void main(String[] args) {
        int count = 20;
        int [] array = getRandomArray(count);
        printArray(array, count);
        int [] sortedArray = BubbleSort.bubbleSort(array);
        printArray(sortedArray, count);
        int result = BinarySearch.binarySearch(sortedArray, 2);
        System.out.println(result);
    }

    private static int [] getRandomArray(int count){
        int [] _array = new int[count];
        for (int i = 0; i < count; i++){
            _array[i] = (int)(Math.random()*100);
        }
        return _array;
    }

    public static void printArray(int [] array, int count){
        for (int i = 0; i < count; i++){
            System.out.print(array[i] + "; ");
        }
        System.out.println(" ");
    }
}