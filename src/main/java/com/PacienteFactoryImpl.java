package com;

import com.Interfaces.PacienteFactory;

class PacienteFactoryImpl implements PacienteFactory {
    @Override
    public Paciente createPaciente(String nombre, String sintoma, char codigoEmergencia) {
        return new Paciente(nombre, sintoma, codigoEmergencia);
    }
}