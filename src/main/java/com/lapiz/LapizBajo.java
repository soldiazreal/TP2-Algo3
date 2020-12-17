package com.lapiz;

import com.arista.Arista;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;

public class LapizBajo extends Lapiz{

    public LapizBajo(){

    }

    public void usar(Posicion inicio, Posicion actual, SeccionDibujo seccionDibujo){
        seccionDibujo.agregarArista (new Arista(inicio, actual));
    }
}