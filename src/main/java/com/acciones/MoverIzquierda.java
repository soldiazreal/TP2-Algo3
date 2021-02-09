package com.acciones;
import com.excepciones.PersonajeNullException;
import com.personaje.*;

public class MoverIzquierda implements Accion{

    public MoverIzquierda(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        MoverDerecha accionInversa = new MoverDerecha();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        unPersonaje.mover(-1,0);
    }
}