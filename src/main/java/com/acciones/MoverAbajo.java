package com.acciones;;
import com.personaje.*;

public class MoverAbajo implements Accion{

    public MoverAbajo(){}

    @Override
    public void invertir(Personaje unPersonaje){
        MoverArriba accionInversa = new MoverArriba();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        unPersonaje.mover(0,-1);
    }
}