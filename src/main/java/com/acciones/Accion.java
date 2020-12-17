package com.acciones;
import com.personaje.*;


public interface Accion{

    public abstract void invertir(Personaje unPersonaje);

    public abstract void accionar(Personaje unPersonaje);
}