package com.personaje;
import com.lapiz.*;
import com.tablero.*;
import com.posicion.*;

public class Personaje{

    private SeccionDibujo seccionDibujo;
    private Posicion posicionActual;
    private Lapiz lapiz = new LapizLevantado();

    public Personaje(Posicion posicionActual, SeccionDibujo seccionDibujo) {
        this.seccionDibujo = seccionDibujo;
        this.posicionActual = posicionActual;
    }

    public void mover(int variacionX, int variacionY) {
        Posicion posicionInicio = new Posicion(posicionActual.getX(),posicionActual.getY());
        Posicion posicionFinal = new Posicion(0,0);
        posicionActual.modificarCoordenadas(variacionX, variacionY);
        posicionFinal.modificarCoordenadas(posicionActual.getX(), posicionActual.getY());
        lapiz.usar(posicionInicio, posicionFinal, seccionDibujo);
    }

    public void asignarLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }

    public Posicion getPosicionActual(){
        return this.posicionActual;
    }
}