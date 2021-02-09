package com.bloques;

import com.personaje.Personaje;

public class Inversion extends Secuencial{

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        for (Bloque elBloque : this.bloques) {
            elBloque.ejecutarBloque(unPersonaje);
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        for(Bloque elBloque: this.bloques){
            elBloque.invertirBloque(unPersonaje);
        }
    }
}
