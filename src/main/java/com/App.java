package com;

import com.Interfaces.QueueFactory;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de la cola de prioridad:");
        System.out.println("1. VectorHeap");
        System.out.println("2. java.util.PriorityQueue");
        int choice = scanner.nextInt();
        QueueFactory<Paciente> factory;
        
        switch (choice) {
            case 1:
                factory = new VectorHeapFactory<>();
                break;
            case 2:
                factory = new JavaPriorityQueueFactory<>();
                break;
            default:
                System.out.println("Opción no válida. Se utilizará VectorHeap por defecto.");
                factory = new VectorHeapFactory<>();
        }

        PriorityQueueManager manager = new PriorityQueueManager(factory);
        manager.run();
    }
}
