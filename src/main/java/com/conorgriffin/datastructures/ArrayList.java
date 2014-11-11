package com.conorgriffin.datastructures;

public class ArrayList<T> implements List<T> {
    
    private int size;
    private int front;
    private int rear;
    
    public ArrayList() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) return false;
        return true;
    }

    @Override
    public Position<T> first() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> last() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> prev(Position<T> p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> next(Position<T> p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> insertFirst(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> insertLast(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> insertBefore(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<T> insertAfter(T item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T replace(Position<T> p, T item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove(Position<T> p) {
        // TODO Auto-generated method stub
        return null;
    }

}
