package com.acciones;
import com.excepciones.PersonajeNullException;
import com.personaje.*;


public class MoverArriba implements Accion{

    public MoverArriba(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        MoverAbajo accionInversa = new MoverAbajo();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        unPersonaje.mover(0,1);
    }
}