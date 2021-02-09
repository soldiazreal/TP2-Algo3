package com.factory;

import com.acciones.LevantarLapiz;
import com.bloques.Individual;

public class BloqueLevantarLapiz implements CrearBloque {
    @Override
    public Individual generarBloque() {
        LevantarLapiz accion = new LevantarLapiz();
        return new Individual("LevantarLapiz", accion);
    }
}
