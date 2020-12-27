package com.factory;

import com.acciones.MoverAbajo;
import com.bloques.Bloque;
import com.bloques.Individual;

public class BloqueMoverAbajo implements CrearBloque{
    @Override
    public Bloque generar() {
        MoverAbajo accion = new MoverAbajo();
        Individual bloque =  new Individual("MoverAbajo", accion);
        return bloque;
    }
}
