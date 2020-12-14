package com.acciones;
import com.personaje.*;

public class MoverAbajo extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        MoverArriba accionInversa = new Accion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje mover(0,-1);
    }
}