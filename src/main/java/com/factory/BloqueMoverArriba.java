package com.factory;

import com.acciones.MoverArriba;
import com.bloques.Individual;

public class BloqueMoverArriba implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        MoverArriba accion = new MoverArriba();
        Individual bloque =  new Individual("MoverArriba", accion);
        return bloque;
    }
}
