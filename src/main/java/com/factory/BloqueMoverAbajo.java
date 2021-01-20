package com.factory;

import com.acciones.MoverAbajo;
import com.bloques.Individual;

public class BloqueMoverAbajo implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        MoverAbajo accion = new MoverAbajo();
        Individual bloque =  new Individual("MoverAbajo", accion);
        return bloque;
    }
}
