package com.acciones;
import com.lapiz.*;
import com.personaje.*;


public class LevantarLapiz extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        BajarLapiz accionInversa = new Accion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        LapizLevantado unLapiz = new LapizBajo();
        unPersonaje asignarLapiz(unLapiz);
    }
}