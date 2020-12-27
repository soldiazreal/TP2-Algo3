package com.bloques;

import com.acciones.*;
import com.personaje.*;

public abstract class Bloque {
    protected final String nombre;

    protected Bloque(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public abstract void ejecutarBloque(Personaje unPersonaje);
}
