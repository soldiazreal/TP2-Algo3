package com.acciones;
import com.lapiz.*;
import com.personaje.*;

public class BajarLapiz implements Accion {

    public BajarLapiz(){}

    @Override
    public void invertir(Personaje unPersonaje){
        LevantarLapiz accionInversa = new LevantarLapiz();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        LapizBajo unLapiz = new LapizBajo();
        unPersonaje.asignarLapiz(unLapiz);
    }
}