package com.personaje;
import com.excepciones.PosicionANullException;
import com.excepciones.SeccionDibujoNullException;
import com.lapiz.*;
import com.tablero.*;
import com.posicion.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.LinkedList;

public class Personaje implements Observable {

    LinkedList<InvalidationListener> observadores = new LinkedList<>();

    private SeccionDibujo seccionDibujo;
    private Posicion posicionActual;
    private Lapiz lapiz = new LapizLevantado();

    public Personaje(Posicion posicionActual, SeccionDibujo seccionDibujo) {
        if (posicionActual == null)
            throw new PosicionANullException("No se puede crear Personaje con posicion a Null");
        if (seccionDibujo == null)
            throw new SeccionDibujoNullException("No se puede crear Personaje con SeccionDibujo a Null");
        this.seccionDibujo = seccionDibujo;
        this.posicionActual = posicionActual;
    }

    public void mover(int variacionX, int variacionY) {
        Posicion posicionInicio = posicionActual.copiaDePosicion();
        posicionActual.modificarCoordenadas(variacionX, variacionY);
        Posicion posicionFinal = posicionActual.copiaDePosicion();
        lapiz.usar(posicionInicio, posicionFinal, seccionDibujo);
        this.notificar();
    }

    public void asignarLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }

    public Posicion getPosicionActual(){
        return this.posicionActual;
    }

    public SeccionDibujo getSeccionDibujo() {
        return seccionDibujo;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        observadores.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        observadores.remove(invalidationListener);
    }

    public void notificar() {
        for (InvalidationListener observador : observadores) {
            observador.invalidated(null);
        }
    }
}