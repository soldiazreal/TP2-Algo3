package com.factory;

import com.acciones.MoverDerecha;
import com.bloques.Bloque;
import com.bloques.Individual;

public class BloqueMoverDerecha implements CrearBloque{
    @Override
    public Individual generar() {
        MoverDerecha accion = new MoverDerecha();
        Individual bloque =  new Individual("MoverDerecha", accion);
        return bloque;
    }
}
