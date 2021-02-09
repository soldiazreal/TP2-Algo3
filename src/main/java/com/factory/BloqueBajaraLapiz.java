package com.factory;

import com.acciones.*;
import com.bloques.Individual;

public class BloqueBajaraLapiz implements CrearBloque {
    @Override
    public Individual generarBloque() {
        BajarLapiz accion = new BajarLapiz();
       return new Individual("BajarLapiz", accion);
    }
}
