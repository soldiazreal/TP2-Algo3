package com.acciones;
import com.lapiz.*;

public class BajarLapiz extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        LevantarLapiz accionInversa = new Accion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        LapizBajo unLapiz = new LapizBajo();
        unPersonaje asignarLapiz(unLapiz);
    }
}