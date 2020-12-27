package com.factory;

import com.bloques.Bloque;
import com.acciones.*;
import com.bloques.Individual;

public class BloqueBajaraLapiz implements CrearBloque{
    @Override
    public Bloque generar() {
        BajarLapiz accion = new BajarLapiz();
       Individual bloque =  new Individual("BajarLapiz", accion);
       return bloque;
    }
}
