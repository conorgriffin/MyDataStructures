package com.conorgriffin.algorithms;

public class MergeSort<T extends Comparable<? super T>> {
    
    private T A[];
    
    public MergeSort(T[] items) {
        this.A = (T[])items;
    }
}
