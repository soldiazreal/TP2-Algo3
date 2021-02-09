package com.tablero;

import com.bloques.Bloque;
import com.excepciones.BloqueInexistenteException;
import com.factory.*;

import java.util.*;

public class SeccionBloques {

    private final HashMap<String, CrearBloque> bloquesDisponibles;

    public SeccionBloques(){
        this.bloquesDisponibles = new HashMap<>();
        bloquesDisponibles.put("BajarLapiz", new BloqueBajaraLapiz());
        bloquesDisponibles.put("LevantarLapiz", new BloqueLevantarLapiz());
        bloquesDisponibles.put("MoverAbajo", new BloqueMoverAbajo());
        bloquesDisponibles.put("MoverArriba", new BloqueMoverArriba());
        bloquesDisponibles.put("MoverIzquierda", new BloqueMoverIzquierda());
        bloquesDisponibles.put("MoverDerecha", new BloqueMoverDerecha());
        bloquesDisponibles.put("RepetirDoble", new BloqueRepetirDoble());
        bloquesDisponibles.put("RepetirTriple", new BloqueRepetirTriple());
        bloquesDisponibles.put("Invertir", new BloqueInvertir());

    }

    public void agregarBloque (String unNombre,CrearBloque unConstructor) {
        bloquesDisponibles.put(unNombre, unConstructor);
    }

    public Bloque buscarBloque (String unNombre) {
        CrearBloque unConstructor = bloquesDisponibles.get(unNombre);
        if (unConstructor == null){
            throw new BloqueInexistenteException("Error no existe bloque buscado");
        }
        return unConstructor.generarBloque();
    }
}
