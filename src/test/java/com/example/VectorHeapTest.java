package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.VectorHeap;

public class VectorHeapTest {

    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        
        // Añadir elementos al heap
        assertTrue(heap.add(5));
        assertTrue(heap.add(3));
        assertTrue(heap.add(7));
        assertTrue(heap.add(1));
        assertTrue(heap.add(9));
        
        // Verificar si el tamaño es correcto
        assertEquals(5, heap.size());
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        
        // Añadir elementos al heap
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(9);
        
        // Eliminar elementos en orden y verificar si son correctos
        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertEquals(Integer.valueOf(7), heap.remove());
        assertEquals(Integer.valueOf(9), heap.remove());
        
        // Verificar si el heap está vacío
        assertTrue(heap.isEmpty());
    }
}