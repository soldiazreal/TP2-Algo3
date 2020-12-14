package com.acciones;

public class MoverDerecha extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        MoverIzquierda accionInversa = new crearAccion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje mover(1,0);
    }
}