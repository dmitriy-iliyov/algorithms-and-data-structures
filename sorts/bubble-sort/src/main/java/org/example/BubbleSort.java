package org.example;

public class BubbleSort {
    public static int[] bubbleSort(int[] a){
        for( int i=0; i < a.length; i++){
            for(int j=a.length-1; j > i; j-- ){
                if ( a[j-1] > a[j]){
                    int tmp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=tmp;
                }
            }
        }
        return a;
    }

}
