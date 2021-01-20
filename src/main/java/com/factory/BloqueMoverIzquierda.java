package com.factory;

import com.acciones.MoverIzquierda;
import com.bloques.Individual;

public class BloqueMoverIzquierda implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        MoverIzquierda accion = new MoverIzquierda();
        Individual bloque =  new Individual("MoverIzquierda", accion);
        return bloque;
    }
}
