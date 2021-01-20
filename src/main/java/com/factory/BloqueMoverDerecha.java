package com.factory;

import com.acciones.MoverDerecha;
import com.bloques.Individual;

public class BloqueMoverDerecha implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        MoverDerecha accion = new MoverDerecha();
        Individual bloque =  new Individual("MoverDerecha", accion);
        return bloque;
    }
}
