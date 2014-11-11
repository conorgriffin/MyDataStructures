package com.conorgriffin.datastructures;

import java.util.Arrays;

import com.conorgriffin.exceptions.BoundaryViolationException;

/**
 * An ArrayVector stores elements in arrays in a specified order.  Inserting elements
 * as a specific rank moves all the subsequent elements up.  Similarly, deleting from
 * a specific rank, moves all the subsequent elements down.  When the number of items
 * grows beyond the initial array size, the Vector automatically extends its capacity
 * by making a copy of the current array to a new one with twice the capacity.
 * 
 * @author conorgriffin
 *
 * @param <E> the type of object being stored
 */
public class ArrayVector<E> implements Vector<E> {
    
    private int capacity;
    private int size;
    private E Q[];
    
    @SuppressWarnings("unchecked")
    public ArrayVector(int capacity) {
        this.capacity = capacity;
        size = 0;
        Q = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    @Override
    public void insertAtRank(E element, int rank) {
        if(rank < 0 || rank > size) 
            throw new BoundaryViolationException("Rank:'" + rank + "' cannot be less than zero or higher than current number of elements:" + size);
        if(size == capacity) {
            extend();
            insertAtRank(element, rank);
            // return here ensures we don't increment size twice
            return;
        } else {
            if(!isEmpty()) {
                for(int i = size; i >= rank; i--) {
                    Q[i] = Q[i-1];
                }
            }
            Q[rank] = element;
        }
        size++;
    }

    @Override
    public void removeAtRank(int rank) {
        if(rank < 0 || rank > size) {
            throw new BoundaryViolationException("Rank:'" + rank + "' cannot be less than zero or higher than current number of elements:" + size);
        } else {
            int lastElement = size - 1;
            // if there's more than 1 element, shuffle them all down one place as far as rank
            if(lastElement > 0) {
                for(int i = lastElement; i >= rank; i--) {
                    Q[i-1] = Q[i];
                }
            }
            Q[lastElement] = null;
        }
        size--;
    }

    @Override
    public void replaceAtRank(E element, int rank) {
        if(rank < 0 || rank > size) {
            throw new BoundaryViolationException("Rank:'" + rank + "' cannot be less than zero or higher than current number of elements:" + size);
        } else {
            Q[rank] = element;
        }
    }

    @Override
    public E elementAtRank(int rank) {
        if(rank < 0 || rank > size) {
            throw new BoundaryViolationException("Rank:'" + rank + "' cannot be less than zero or higher than current number of elements:" + size);
        } else {
            return Q[rank];
        }
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    private void extend() {
        capacity = size*2;
        E[] R = Arrays.copyOf(Q, capacity);
        Q = R;
    }
    
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        if(!isEmpty()) {
            string.append(Q[0]);
            for(int i = 1; i < size; i++) {
                string.append(", " + Q[i].toString());
            }
        }
        string.append("]");
        return string.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removeAllItems() {
        Q = (E[]) new Object[capacity];
        size = 0;
    }

}
