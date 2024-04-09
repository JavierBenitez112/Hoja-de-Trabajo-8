package com;

import com.Interfaces.PacienteFactory;

public class App {
    public static void main(String[] args) {
        PacienteFactory factory = new PacienteFactoryImpl();
        PriorityQueueManager manager = new PriorityQueueManager(factory);
        manager.run();
    }
}