package com.conorgriffin.datastructures;

import com.conorgriffin.exceptions.EmptyQueueException;
import com.conorgriffin.exceptions.FullQueueException;

public interface Queue<E extends Comparable<? super E>> {
    public void enqueue(E element) throws FullQueueException;
    public E dequeue() throws EmptyQueueException;
    public E head() throws EmptyQueueException;
    public boolean isEmpty();
    public boolean isFull();
    public int size();
}
