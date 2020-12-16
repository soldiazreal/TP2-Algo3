package com.acciones;
import com.personaje.*;


interface Accion{

    public abstract void invertir(Personaje unPersonaje);

    public abstract void accionar(Personaje unPersonaje);
}