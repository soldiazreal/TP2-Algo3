package com.acciones;
import com.excepciones.PersonajeNullException;
import com.lapiz.*;
import com.personaje.*;

public class BajarLapiz implements Accion {

    public BajarLapiz(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        LevantarLapiz accionInversa = new LevantarLapiz();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        LapizBajo unLapiz = new LapizBajo();
        unPersonaje.asignarLapiz(unLapiz);
    }
}