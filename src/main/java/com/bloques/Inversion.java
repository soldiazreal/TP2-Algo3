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

    @Override
    public Bloque copia(){
        Inversion inversion = new Inversion();
        for (Bloque unBloque: this.bloques){
            inversion.agregarBloque(unBloque.copia());
        }
        return inversion;
    }
}
