package org.example;

public class InsertSort {
    public static int[] insertSort(int [] array){
        for(int i = 1; i < array.length; i++){
           for(int j = i; j > 0 && array[j-1] > array[j]; j--){
               int tmp = array[j-1];
               array[j-1] = array[j];
               array[j] = tmp;
           }
        }
        return array;
    }
}
