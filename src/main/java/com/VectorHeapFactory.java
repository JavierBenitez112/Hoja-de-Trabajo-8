package com;

import com.Interfaces.PriorityQueue;
import com.Interfaces.QueueFactory;

public class VectorHeapFactory<E extends Comparable<E>> implements QueueFactory<E> {
    @Override
    public PriorityQueue<E> createQueue() {
        return new VectorHeap<>();
    }
}
