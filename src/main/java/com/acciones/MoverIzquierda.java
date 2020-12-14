package com.acciones;
import com.personaje.*;

public class MoverIzquierda extends Accion{

    @Override
    public void invertir(Personaje unPersonaje){
        MoverDerecha accionInversa = new Accion();
        accionInversa ejecutar(unPersonaje);
    }

    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje mover(-1,0);
    }
}