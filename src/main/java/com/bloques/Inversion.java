package com.bloques;

import com.nodos.Nodo;
import com.personaje.Personaje;

public class Inversion extends Secuencial{

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        bloques.ejecutar(unPersonaje);
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje){
        bloques.invertir(unPersonaje);
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
