package com.arista;
import com.posicion.*;

public class Arista {

    Posicion posicionInicio;
    Posicion posicionFin;

    public Posicion getPosicionInicial (){
        return posicionInicio;
    }

    public Posicion getPosicionFinal (){
        return posicionFin;
    }

    public Arista(Posicion posicionInicio, Posicion posicionFin){
        this.posicionInicio = posicionInicio;
        this.posicionFin = posicionFin;
    }
}
