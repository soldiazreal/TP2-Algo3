package com.factory;

import com.acciones.MoverIzquierda;
import com.bloques.Bloque;
import com.bloques.Individual;

public class BloqueMoverIzquierda implements CrearBloque{
    @Override
    public Bloque generar() {
        MoverIzquierda accion = new MoverIzquierda();
        Individual bloque =  new Individual("MoverIzquierda", accion);
        return bloque;
    }
}
