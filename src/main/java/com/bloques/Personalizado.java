package com.bloques;

import com.personaje.Personaje;

import java.util.ArrayList;

public class Personalizado extends Secuencial {

    String nombre;

    public  Personalizado (Bloque unBloque) {
        super(unBloque);
    }
    /*public Personalizado(ArrayList<Bloque> bloquesACopiar, String nombreAlgoritmo){
        this.nombre = nombreAlgoritmo;

        for (Bloque unBloque: bloquesACopiar){
            this.bloques.add(unBloque.copia);
        }
    }
    */

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
