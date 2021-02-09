package com.factory;

import com.acciones.MoverIzquierda;
import com.bloques.Individual;

public class BloqueMoverIzquierda implements CrearBloque {
    @Override
    public Individual generarBloque() {
        MoverIzquierda accion = new MoverIzquierda();
        return new Individual("MoverIzquierda", accion);
    }
}
