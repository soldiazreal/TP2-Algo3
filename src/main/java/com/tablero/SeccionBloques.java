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
        bloquesDisponibles.put("BajarLapiz", new Individual("BajarLapiz", new BajarLapiz()));
        bloquesDisponibles.put("LevantarLapiz", new Individual("LevantarLapiz", new LevantarLapiz()));
        bloquesDisponibles.put("MoverAbajo", new Individual("MoverAbajo", new MoverAbajo()));
        bloquesDisponibles.put("MoverArriba", new Individual("MoverArriba", new MoverArriba()));
        bloquesDisponibles.put("MoverIzquierda", new Individual("MoverIzquierda", new MoverIzquierda()));
        bloquesDisponibles.put("MoverDerecha", new Individual("MoverDerecha", new MoverDerecha()));
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
        return bloque;
    }
}
