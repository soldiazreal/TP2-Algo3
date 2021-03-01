package com.bloques;

import com.nodos.Nodo;
import com.personaje.Personaje;

public class Inversion extends Secuencial{

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        Nodo nodoAux = this.bloques;
        while(!(nodoAux.esUltimo())){
            nodoAux.ejecutar(unPersonaje);
            nodoAux = nodoAux.conseguirSiguiente();
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        Nodo nodoAux = this.bloques;
        while(!(nodoAux.esUltimo())){
            nodoAux.invertir(unPersonaje);
            nodoAux = nodoAux.conseguirSiguiente();
        }
    }

    @Override
    public Bloque copia(){
        Inversion inversion = new Inversion();
        Nodo nodoAux = this.bloques;
        while(!(nodoAux.esUltimo())){
            inversion.agregarBloque(nodoAux.copiar());
            nodoAux = nodoAux.conseguirSiguiente();
        }
        return inversion;
    }
}
