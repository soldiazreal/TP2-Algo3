package com.acciones;

public class MoverArriba extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        MoverAbajo accionInversa = new crearAccion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje mover(0,1);
    }
}