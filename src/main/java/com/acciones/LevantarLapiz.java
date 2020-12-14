package com.acciones;

public class LevantarLapiz extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        BajarLapiz accionInversa = new crearAccion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        LapizLevantado unLapiz = new crearLapizBajo();
        unPersonaje asignarLapiz(unLapiz);
    }
}