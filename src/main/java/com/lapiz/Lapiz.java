package com.lapiz;

import com.posicion.Posicion;
import com.tablero.SeccionDibujo;

public abstract class Lapiz{

    public abstract void usar(Posicion incio, Posicion actual, SeccionDibujo seccionDibujo);
}