package com.bloques;

import com.excepciones.ValorInvalidoException;
import com.nodos.Nodo;
import com.personaje.Personaje;

public class Repeticion extends Secuencial{
    private int repeticiones;

    public Repeticion(int repeticiones) {
        if (repeticiones <= 0){
            throw new ValorInvalidoException("No se puede crear el bloque con repeticiones negativo");
        }
        this.repeticiones = repeticiones;
    }

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        for(int i = 0; i < this.repeticiones; i++) {
            bloques.invertir(unPersonaje);
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        for(int i = 1; i <= this.repeticiones; i++) {
            bloques.ejecutar(unPersonaje);
        }
    }

    @Override
    public Bloque copia(){
        Repeticion repeticion = new Repeticion(this.repeticiones);
        Nodo nodoAux = this.bloques;
        while(!(nodoAux.esUltimo())){
            repeticion.agregarBloque(nodoAux.copiar());
            nodoAux = nodoAux.conseguirSiguiente();
        }
        return repeticion;
    }
}
