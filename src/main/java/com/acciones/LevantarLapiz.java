package com.acciones;
import com.excepciones.PersonajeNullException;
import com.lapiz.*;
import com.personaje.*;


public class LevantarLapiz implements Accion{

    public LevantarLapiz(){}

    @Override
    public void invertir(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        BajarLapiz accionInversa = new BajarLapiz();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        if (unPersonaje == null)
            throw new PersonajeNullException("No se puede usar Accion con personaje a null");
        LapizLevantado unLapiz = new LapizLevantado();
        unPersonaje.asignarLapiz(unLapiz);
    }
}