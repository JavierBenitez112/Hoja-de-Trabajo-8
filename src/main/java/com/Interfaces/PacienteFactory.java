package com.Interfaces;

import com.Paciente;

public interface PacienteFactory {
    Paciente createPaciente(String nombre, String sintoma, char codigoEmergencia);
}