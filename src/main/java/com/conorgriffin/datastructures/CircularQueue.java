package com.conorgriffin.datastructures;

import com.conorgriffin.exceptions.EmptyQueueException;
import com.conorgriffin.exceptions.FullQueueException;

public class CircularQueue<E extends Comparable<? super E>> implements Queue<E> {
    private int size;
    private int capacity;
    private E Q[];
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
       this.capacity = capacity;
       Q = (E[]) new Object[capacity];
       head = 0;
       tail = 0;
    }
    
    public void enqueue(E element) throws FullQueueException {
       if (isFull()) {
           throw new FullQueueException("Cannot enqueue an element on a full queue");
       }
       else {
          Q[tail] = element;
          size++;
          tail = (tail + 1) % capacity;
       }
    }

    public int size() {
        return this.size;
    }
    
    public E dequeue() throws EmptyQueueException {

       if (isEmpty()) {
           throw new EmptyQueueException("Cannot dequeue an element from an empty queue");
       }
       E element = Q[head];
       head = (head + 1) % capacity;
       size--;
       return element;
    }

    public boolean isEmpty() {
       return head == tail;
    }

    public boolean isFull() {
       return head == (tail + 1) % capacity;
    }

    public E head() throws EmptyQueueException {
       if (!isEmpty())
          return Q[head];
       else throw new EmptyQueueException("Cannot fetch an element from an empty queue");
    }

    public void dumpQ(int i) throws EmptyQueueException {
       System.out.println("i:" + i +
         ", head:" + head + ", tail:" + tail +
         ", Q[head]:" + head());
    }
 }
