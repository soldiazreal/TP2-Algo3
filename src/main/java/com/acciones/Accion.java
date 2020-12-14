package com.acciones;

interface Accion{

    public crearAccion();

    public abstract void invertir(Personaje unPersonaje);

    public abstract void accionar(Personaje unPersonaje);
}