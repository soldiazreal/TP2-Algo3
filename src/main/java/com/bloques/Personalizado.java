package com.bloques;

import com.personaje.Personaje;

import java.util.ArrayList;

public class Personalizado extends Secuencial {

    String nombre;

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        for (Bloque unBloque: this.bloques){
            unBloque.ejecutarBloque(unPersonaje);
        }
    }

    @Override
    public void invertirBloque (Personaje unPersonaje){
        for (Bloque unBloque: this.bloques){
            unBloque.invertirBloque(unPersonaje);
        }
    }
}
