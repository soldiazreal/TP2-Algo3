package com.factory;

import com.acciones.MoverDerecha;
import com.bloques.Individual;

public class BloqueMoverDerecha implements CrearBloque {
    @Override
    public Individual generarBloque() {
        MoverDerecha accion = new MoverDerecha();
        return new Individual("MoverDerecha", accion);
    }
}
