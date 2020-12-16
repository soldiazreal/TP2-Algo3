package com.acciones;
import com.personaje.*;


public class MoverArriba implements Accion{

    public MoverArriba(){}

    @Override
    public void invertir(Personaje unPersonaje){
        MoverAbajo accionInversa = new MoverAbajo();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        unPersonaje.mover(0,1);
    }
}