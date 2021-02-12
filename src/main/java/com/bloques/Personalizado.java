package com.bloques;

import com.personaje.Personaje;
import com.tablero.SeccionBloques;

import java.util.ArrayList;
import java.util.List;

public class Personalizado extends Secuencial {

    private String nombre;

    public Personalizado (String nombreNuevo){
        this.nombre = nombreNuevo;
    }

    public void guardarAlgoritmo(List<Bloque> algoritmo){
        for (Bloque unBloque: algoritmo){
            this.bloques.add(unBloque.copia());
        }
    }

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

    @Override
    public Bloque copia(){
        Personalizado personalizado = new Personalizado(this.nombre);
        for (Bloque unBloque: this.bloques){
            personalizado.agregarBloque(unBloque.copia());
        }
        return personalizado;
    }
}
