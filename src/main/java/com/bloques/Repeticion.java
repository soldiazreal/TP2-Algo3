package com.bloques;

import com.personaje.Personaje;

public class Repeticion extends Secuencial{
    private int repeticiones;

    public Repeticion(Bloque unBloque, int repeticiones) {
        super(unBloque);
        this.repeticiones = repeticiones;
    }

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        for(int i = 0; i < repeticiones; ++i){
            for (Bloque elBloque : this.bloques) {
                elBloque.invertirBloque(unPersonaje);
            }
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        for(int i = 0; i < repeticiones; ++i){
            for (Bloque elBloque : this.bloques) {
             elBloque.ejecutarBloque(unPersonaje);
            }
        }
    }
}
