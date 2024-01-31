package org.example;

public class ShellSort {
    public static int [] shellSort(int [] array){
        for(int step = array.length/2; step > 0; step/=2){
            for (int i = step; i < array.length; i++){
                for (int j = i - step; j >= 0 && array[j] > array[j + step]; j-=step){
                    int tmp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = tmp;
                }
            }
        }

        return array;
    }
}
