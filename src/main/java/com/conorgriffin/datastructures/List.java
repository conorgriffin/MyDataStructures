package com.conorgriffin.datastructures;

public interface List<T> {
    public int size();
    public boolean isEmpty();
    public Position<T> first();
    public Position<T> last();
    public Position<T> prev(Position<T> p);
    public Position<T> next(Position<T> p);
    public Position<T> insertFirst(T item);
    public Position<T> insertLast(T item);
    public Position<T> insertBefore(T item);
    public Position<T> insertAfter(T item);
    public T replace(Position<T> p, T item);
    public T remove(Position<T> p);
}
