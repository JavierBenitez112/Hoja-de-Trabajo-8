package com.Interfaces;

public interface PriorityQueue<E> {
    boolean add(E value);

    E remove();

    E peek();

    boolean isEmpty();

    int size();

    void clear();
}