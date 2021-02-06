package com.factory;

import com.acciones.MoverAbajo;
import com.bloques.Individual;

public class BloqueMoverAbajo implements CrearBloque {
    @Override
    public Individual generarBloque() {
        MoverAbajo accion = new MoverAbajo();
        return new Individual("MoverAbajo", accion);
    }
}
