package com.factory;

import com.acciones.LevantarLapiz;
import com.bloques.Individual;

public class BloqueLevantarLapiz implements CrearBloqueIndividual {
    @Override
    public Individual generarIndividual() {
        LevantarLapiz accion = new LevantarLapiz();
        Individual bloque =  new Individual("LevantarLapiz", accion);
        return bloque;
    }
}
