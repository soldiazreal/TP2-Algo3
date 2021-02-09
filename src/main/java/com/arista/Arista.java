package com.arista;
import com.excepciones.PosicionANullException;
import com.posicion.*;

public class Arista {

    private Posicion posicionInicio;
    private Posicion posicionFin;

    public Posicion getPosicionInicial (){
        return posicionInicio;
    }

    public Posicion getPosicionFinal (){
        return posicionFin;
    }

    public Arista(Posicion posicionInicio, Posicion posicionFin){
        if (posicionInicio == null)
            throw new PosicionANullException("No se puede crear Arista con posicionInicio a null");
        if (posicionFin == null)
            throw new PosicionANullException("No se puede crear Arista con posicionFin a null");
        this.posicionInicio = posicionInicio;
        this.posicionFin = posicionFin;
    }
}
