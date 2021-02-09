package com.acciones;
import com.excepciones.PersonajeNullException;
import com.personaje.*;


public class MoverDerecha implements Accion{

    public MoverDerecha(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        MoverIzquierda accionInversa = new MoverIzquierda();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        unPersonaje.mover(1,0);
    }
}