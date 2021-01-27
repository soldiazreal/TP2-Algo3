package com.tablero;

import com.acciones.*;
import com.bloques.Bloque;
import com.bloques.Individual;
import com.bloques.Secuencial;
import com.personaje.Personaje;

import java.lang.reflect.Type;
import java.util.*;

public class SeccionBloques {

    private final HashMap<String,Bloque> bloquesDisponibles;

    public SeccionBloques(){
        this.bloquesDisponibles = new HashMap<>();
        bloquesDisponibles.put("BajarLapiz", new Individual("BajarLapiz", new BajarLapiz()));
        bloquesDisponibles.put("LevantarLapiz", new Individual("LevantarLapiz", new LevantarLapiz()));
        bloquesDisponibles.put("MoverAbajo", new Individual("MoverAbajo", new MoverAbajo()));
        bloquesDisponibles.put("MoverArriba", new Individual("MoverArriba", new MoverArriba()));
        bloquesDisponibles.put("MoverIzquierda", new Individual("BajarLapiz", new MoverIzquierda()));
        bloquesDisponibles.put("MoverDerecha", new Individual("MoverDerecha", new MoverDerecha()));
    }

    public Bloque buscarBloqueIndividual (String unNombre) {
        return bloquesDisponibles.get(unNombre);
    }
}
