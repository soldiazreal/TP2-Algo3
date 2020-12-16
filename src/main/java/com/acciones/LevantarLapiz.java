package com.acciones;
import com.lapiz.*;
import com.personaje.*;


public class LevantarLapiz implements Accion{

    public LevantarLapiz(){}

    @Override
    public void invertir(Personaje unPersonaje){
        BajarLapiz accionInversa = new BajarLapiz();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        LapizLevantado unLapiz = new LapizLevantado();
        unPersonaje.asignarLapiz(unLapiz);
    }
}