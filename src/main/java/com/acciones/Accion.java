package com.acciones;

interface Accion{

    public Accion(){}

    public abstract void invertir(Personaje unPersonaje){}

    public abstract void accionar(Personaje unPersonaje){}
}