package com.factory;

import com.acciones.MoverArriba;
import com.bloques.Individual;

public class BloqueMoverArriba implements CrearBloque {
    @Override
    public Individual generarBloque() {
        MoverArriba accion = new MoverArriba();
        return new Individual("MoverArriba", accion);
    }
}
