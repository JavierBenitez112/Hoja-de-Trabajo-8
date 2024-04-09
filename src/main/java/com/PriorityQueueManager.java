package com;

import com.Interfaces.PriorityQueue;
import com.Interfaces.QueueFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriorityQueueManager {
    private PriorityQueue<Paciente> emergencias;

    public PriorityQueueManager(QueueFactory<Paciente> factory) {
        this.emergencias = factory.createQueue();
    }

    public void run() {
        cargarPacientes();
        atenderPacientes();
    }

    private void cargarPacientes() {
        try {
            File file = new File("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Hoja-de-Trabajo-8\\src\\main\\java\\com\\pacientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String sintoma = parts[1].trim();
                    char codigoEmergencia = parts[2].trim().charAt(0);
                    emergencias.add(new Paciente(nombre, sintoma, codigoEmergencia));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo 'pacientes.txt'");
            e.printStackTrace();
        }
    }

    private void atenderPacientes() {
        while (!emergencias.isEmpty()) {
            Paciente siguiente = emergencias.remove();
            System.out.println("Siguiente paciente a atender: " + siguiente);
        }
    }
}
