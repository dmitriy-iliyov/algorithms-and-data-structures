package com.company;

class Sort {

    static int[] randArrey(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ((int)(Math.random() * 201) - 100);
        }
        return array;
    }

    static void printArrey(int [] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println(" ");
    }

//  sorts
    static int[] bubbleSort(int[] arr) {
        for( int i=0; i < arr.length; i++)
        {
            for( int j =arr.length -1; j > i; j-- )
            {
                if ( arr[j-1] > arr[j])
                {
                    int tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return arr;
    }

    static int [] selectionSort(int[] arr){
        for(int i = arr.length - 1;i >= 0; i--){
            int max = arr[i];
            int max_index = i;
            for(int j=0; j < i; j++)
            {
                if (max < arr[j]){
                    max = arr[j];
                    max_index = j;
                }
            }
            arr[max_index] = arr[i];
            arr[i] = max;
        }
        return arr;
    }

    static int[] insertSort (int [] arr) {
        for(int i=1;i < arr.length; i++)
        {
            for(int k=i; k>0 &&  arr[k-1]>arr[k]; k--)
            {
                int tmp=arr[k-1];
                arr[k-1]=arr[k];
                arr[k]=tmp;
            }

        }
        return arr;
    }

    static int[] shellSort (int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2)
        {
            for (int i = step; i < arr.length; i++)
            {
                for (int j = i - step; j >= 0 && arr[j] > arr[j + step]; j -= step)
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = tmp;
                }
            }
        }
        return arr;
    }

    static int [] quickSort(int[] arr, int start, int end) {
        //if (arr.length == 0) return arr;
        if (start >= end) return arr;
        int middle = start + (end - start) / 2;
        int pivot = arr[middle];
        int left = start, right = end;
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) quickSort(arr, start, right);
        if (end > left) quickSort(arr, left, end);
        return arr;
    }
}
