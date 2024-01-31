package org.example;

public class SelectionSort {

    public static int [] selectionSort(int [] array){
        for(int i = array.length - 1; i > 0; i--){
            int max = array[i];
            int maxIndex = i;
            for(int j = 0; j < i; j++){
                if(array[j] < max){
                    max = array[j];
                    maxIndex = j;
                }
            }
            array[maxIndex] = array[i];
            array[i] = max;
        }
        return array;
    }
}
