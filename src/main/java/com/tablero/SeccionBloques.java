package com.tablero;

import com.acciones.*;
import com.bloques.Bloque;
import com.bloques.Individual;
import com.bloques.Inversion;
import com.bloques.Repeticion;
import com.excepciones.BloqueInexistenteException;

import java.util.*;

public class SeccionBloques {

    private final HashMap<String, Bloque> bloquesDisponibles;

    public SeccionBloques(){
        this.bloquesDisponibles = new HashMap<>();
        bloquesDisponibles.put("BajarLapiz", new Individual(new BajarLapiz()));
        bloquesDisponibles.put("LevantarLapiz", new Individual(new LevantarLapiz()));
        bloquesDisponibles.put("MoverAbajo", new Individual(new MoverAbajo()));
        bloquesDisponibles.put("MoverArriba", new Individual(new MoverArriba()));
        bloquesDisponibles.put("MoverIzquierda", new Individual(new MoverIzquierda()));
        bloquesDisponibles.put("MoverDerecha", new Individual(new MoverDerecha()));
        bloquesDisponibles.put("RepetirDoble", new Repeticion(2));
        bloquesDisponibles.put("RepetirTriple", new Repeticion(3));
        bloquesDisponibles.put("Invertir", new Inversion());
    }

    public void agregarBloque (String unNombre,Bloque bloque) {
        bloquesDisponibles.put(unNombre, bloque);
    }

    public Bloque buscarBloque (String unNombre) {
        Bloque bloque = bloquesDisponibles.get(unNombre);
        if (bloque == null){
            throw new BloqueInexistenteException("Error no existe bloque buscado");
        }
        return bloque.copia();
    }
}
