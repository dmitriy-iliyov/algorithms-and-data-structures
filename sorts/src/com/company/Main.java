package com.company;
import java.lang.Math;
public class Main {

    private void printArrey(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int [] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int [] arr = Sort.randArrey(11);
        Sort.printArrey(arr);
        int [] b = Sort.bubbleSort(arr);
        Sort.printArrey(b);
        int [] i = Sort.insertSort(arr);
        Sort.printArrey(i);
        int [] s =  Sort.shellSort(arr);
        Sort.printArrey(s);
        int [] q = Sort.quickSort(arr, 0, 9);
        Sort.printArrey(q);
        int [] selection =  Sort.selectionSort(arr);
        for (int value : selection) {
            System.out.print(value + " ");
        }
        System.out.println(" ");
    }
}
