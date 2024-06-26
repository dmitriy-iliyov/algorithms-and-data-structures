package org.example;

public class BinarySearch {
    public static int binarySearch (int [] array, int  x){
        int left = 0;
        int right = array.length-1;

        while (left <= right){
            int mid = (right + left) /2;
            if (x < array[mid])
                right = mid - 1;
            else if(x > array[mid])
                left = mid + 1;
            else
                return array[mid];
        }
        return 0;
    }

}
