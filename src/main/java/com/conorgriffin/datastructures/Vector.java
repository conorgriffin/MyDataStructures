package com.conorgriffin.datastructures;

public interface Vector<E> {
    public int size();
    public boolean isEmpty();
    public void insertAtRank(E element, int rank);
    public void removeAtRank(int rank);
    public void replaceAtRank(E element, int rank);
    public E elementAtRank(int rank);
    public void removeAllItems();
}
