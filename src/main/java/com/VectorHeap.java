package com;

import com.Interfaces.PriorityQueue;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private java.util.Vector<E> data;

    public VectorHeap() {
        data = new java.util.Vector<>();
    }

    @Override
    public boolean add(E value) {
        data.add(value);
        int index = data.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            E parent = data.get(parentIndex);
            if (value.compareTo(parent) >= 0) {
                break;
            }
            data.set(index, parent);
            index = parentIndex;
        }
        data.set(index, value);
        return true;
    }

    @Override
    public E remove() {
        if (data.isEmpty()) {
            return null;
        }
        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            trickleDown(0, lastVal);
        }
        return minVal;
    }

    private void trickleDown(int index, E value) {
        int childIndex = 2 * index + 1;
        while (childIndex < data.size()) {
            if (childIndex < data.size() - 1 &&
                    data.get(childIndex + 1).compareTo(data.get(childIndex)) < 0) {
                childIndex++;
            }
            if (value.compareTo(data.get(childIndex)) <= 0) {
                break;
            }
            data.set(index, data.get(childIndex));
            index = childIndex;
            childIndex = 2 * index + 1;
        }
        data.set(index, value);
    }

    @Override
    public E peek() {
        return data.isEmpty() ? null : data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}