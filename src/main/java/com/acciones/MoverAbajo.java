package com.acciones;
import com.excepciones.PersonajeNullException;
import com.personaje.*;

public class MoverAbajo implements Accion{

    public MoverAbajo(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        MoverArriba accionInversa = new MoverArriba();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        unPersonaje.mover(0,-1);
    }
}