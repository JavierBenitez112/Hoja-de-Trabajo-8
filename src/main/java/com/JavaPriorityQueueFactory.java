package com;

import com.Interfaces.QueueFactory;
import java.util.PriorityQueue;

public class JavaPriorityQueueFactory<E extends Comparable<E>> implements QueueFactory<E> {
    @Override
    public com.Interfaces.PriorityQueue<E> createQueue() {
        return new JavaPriorityQueueAdapter<>();
    }

    private static class JavaPriorityQueueAdapter<E extends Comparable<E>> extends PriorityQueue<E> implements com.Interfaces.PriorityQueue<E> {
        // No es necesario implementar nada aquí, ya que PriorityQueue ya proporciona todos los métodos necesarios
    }
}
