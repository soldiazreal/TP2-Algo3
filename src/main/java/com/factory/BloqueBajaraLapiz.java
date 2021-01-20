package com.factory;

import com.acciones.*;
import com.bloques.Individual;

public class BloqueBajaraLapiz implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        BajarLapiz accion = new BajarLapiz();
       Individual bloque =  new Individual("BajarLapiz", accion);
       return bloque;
    }
}
