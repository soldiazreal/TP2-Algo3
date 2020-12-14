package com.acciones;
import com.personaje.*;


public class MoverArriba extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        MoverAbajo accionInversa = new Accion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje mover(0,1);
    }
}