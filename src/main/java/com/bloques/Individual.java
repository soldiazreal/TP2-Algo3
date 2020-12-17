package com.bloques;

import com.acciones.*;
import com.personaje.Personaje;

public class Individual extends Bloque{

    public Individual(String nombre, Accion unaAccion) {
        super(nombre, unaAccion);
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        super.accion.accionar(unPersonaje);

    }
}
