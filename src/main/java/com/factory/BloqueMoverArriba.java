package com.factory;

import com.acciones.MoverArriba;
import com.bloques.Bloque;
import com.bloques.Individual;

public class BloqueMoverArriba implements CrearBloque{
    @Override
    public Individual generar() {
        MoverArriba accion = new MoverArriba();
        Individual bloque =  new Individual("MoverArriba", accion);
        return bloque;
    }
}
