package com.factory;

import com.acciones.LevantarLapiz;
import com.bloques.Bloque;
import com.bloques.Individual;

public class BloqueLevantarLapiz implements CrearBloque{
    @Override
    public Bloque generar() {
        LevantarLapiz accion = new LevantarLapiz();
        Individual bloque =  new Individual("LevantarLapiz", accion);
        return bloque;
    }
}
