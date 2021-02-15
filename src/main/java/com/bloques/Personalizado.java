package com.bloques;

import com.excepciones.ListaNullException;
import com.excepciones.PersonajeNullException;
import com.personaje.Personaje;
import com.tablero.SeccionBloques;

import java.util.ArrayList;
import java.util.List;

public class Personalizado extends Secuencial {

    public void guardarAlgoritmo(List<Bloque> algoritmo){
        if (algoritmo == null)
            throw new ListaNullException("No se puede guardar algoritmo con algoritmo null");
        for (Bloque unBloque: algoritmo){
            this.bloques.add(unBloque.copia());
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede ejecutar bloque con personaje null");
        for (Bloque unBloque: this.bloques){
            unBloque.ejecutarBloque(unPersonaje);
        }
    }

    @Override
    public void invertirBloque (Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede invertir bloque con personaje null");
        for (Bloque unBloque: this.bloques){
            unBloque.invertirBloque(unPersonaje);
        }
    }

    @Override
    public Bloque copia(){
        Personalizado personalizado = new Personalizado();
        for (Bloque unBloque: this.bloques){
            personalizado.agregarBloque(unBloque.copia());
        }
        return personalizado;
    }
}
