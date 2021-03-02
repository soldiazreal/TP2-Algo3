package com.bloques;

import com.excepciones.ListaNullException;
import com.excepciones.PersonajeNullException;
import com.nodos.Nodo;
import com.nodos.NodoNulo;
import com.personaje.Personaje;


public class Personalizado extends Secuencial {

    public void guardarAlgoritmo(Nodo algoritmo){
        if (algoritmo == null)
            throw new ListaNullException("No se puede guardar algoritmo con algoritmo null");
        Nodo nodoAux = algoritmo;
        while(!(nodoAux.esUltimo())){
            agregarBloque(nodoAux.copiar());
            nodoAux = nodoAux.conseguirSiguiente();
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede ejecutar bloque con personaje null");
        bloques.ejecutar(unPersonaje);
    }

    @Override
    public void invertirBloque (Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede invertir bloque con personaje null");
        bloques.invertir(unPersonaje);
    }

    @Override
    public Bloque copia(){
        Personalizado personalizado = new Personalizado();
        Nodo nodoAux = this.bloques;
        while(!(nodoAux.esUltimo())){
            personalizado.agregarBloque(nodoAux.copiar()) ;
            nodoAux = nodoAux.conseguirSiguiente();
        }
        return personalizado;
    }

    @Override
    public Nodo primerNodoListaInterna(){
        return new NodoNulo();
    }
}
