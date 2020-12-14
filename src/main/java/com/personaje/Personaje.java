package com.personaje;
import com.lapiz.*;
import com.tablero.*;
import com.posicion.*;

public class Personaje{

    SeccionDibujo seccionDibujo = new SeccionDibujo();
    Posicion posicionActual;
    private Lapiz lapiz = new LapizLevantado();

    public Personaje(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void mover(int variacionX, int variacionY) {
        Posicion posicionInicio = posicionActual;
        posicionActual.modificarCoordenadas(variacionX, variacionY);
        lapiz.usar(posicionInicio, posicionActual, seccionDibujo);
    }

    public void asignarLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }
}