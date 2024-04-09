package com;

import com.Interfaces.PriorityQueue;
import java.util.Vector;

/**
 * VectorHeap es una implementación de la interfaz PriorityQueue utilizando un Vector como estructura de datos subyacente.
 * Los elementos en esta cola de prioridad están ordenados según su orden natural, o por un Comparator proporcionado al momento de la construcción de la cola.
 * La cabeza de esta cola es el elemento de menor valor con respecto al orden especificado.
 * Si varios elementos tienen el mismo valor mínimo, la cabeza es uno de esos elementos, pero los empates se rompen de manera arbitraria.
 * Las operaciones de recuperación de la cola como poll, remove, peek y element acceden al elemento en la cabeza de la cola.
 *
 * @param <E> el tipo de elementos contenidos en esta cola de prioridad
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data;

    /**
     * Construye un VectorHeap vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Inserta el elemento especificado en esta cola de prioridad.
     *
     * @param value el elemento a añadir
     * @return true (como se especifica en Collection.add(E))
     */
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

    /**
     * Recupera y elimina la cabeza de esta cola, o devuelve null si esta cola está vacía.
     *
     * @return la cabeza de esta cola, o null si esta cola está vacía
     */
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

    /**
     * Recupera, pero no elimina, la cabeza de esta cola, o devuelve null si esta cola está vacía.
     *
     * @return la cabeza de esta cola, o null si esta cola está vacía
     */
    @Override
    public E peek() {
        return data.isEmpty() ? null : data.get(0);
    }

    /**
     * Devuelve true si esta cola no contiene elementos.
     *
     * @return true si esta cola no contiene elementos
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Devuelve el número de elementos en esta cola.
     *
     * @return el número de elementos en esta cola
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Elimina todos los elementos de esta cola.
     */
    @Override
    public void clear() {
        data.clear();
    }
}
