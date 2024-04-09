package com.Interfaces;

import com.Interfaces.PriorityQueue;

public interface QueueFactory<E> {
    PriorityQueue<E> createQueue();
}
