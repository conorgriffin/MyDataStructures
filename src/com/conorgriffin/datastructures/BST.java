package com.conorgriffin.datastructures;

public interface BST<E extends Comparable<? super E>> {

    public void insert(E k);
    
    public void delete(E k);
    
    public boolean lookup(E k);
    
}
