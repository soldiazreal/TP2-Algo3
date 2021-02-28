package com.tablero;

import  com.bloques.Bloque;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.nodos.*;

public class Tablero {

    private SeccionBloques seccionBloques = new SeccionBloques();
    private SeccionAlgoritmo seccionAlgoritmo = new SeccionAlgoritmo();
    private Personaje personaje = new Personaje(new Posicion(0, 0), new SeccionDibujo());
    private Nodo primerNodo = seccionAlgoritmo.getNodo();

    public void agregarBloque (String unNombre, Nodo unNodo) {
        Bloque bloqueRecibido = seccionBloques.buscarBloque(unNombre);
        seccionAlgoritmo.agregarBloqueDespuesDe(bloqueRecibido, unNodo);
    }

    public void removerBloque (Nodo unNodoPadre) {
        seccionAlgoritmo.removerSiguienteBloque(unNodoPadre);
    }

    public void iniciarAlgoritmo () {
        seccionAlgoritmo.ejecutar(personaje);
    }

    //necesito esto para reiniciar simulacion, se puede mejorar
    public void reiniciar (Personaje personaje) {
        seccionAlgoritmo = new SeccionAlgoritmo();
        this.personaje = personaje;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public Nodo getPrimerNodo(){ return primerNodo;}

    //ojo con esto, es peligroso pero no quedaba otra por el momento
    public void setSeccionBloquesYAlgoritmos (SeccionBloques seccionBloques, SeccionAlgoritmo seccionAlgoritmo)  {
        this.seccionBloques = seccionBloques;
        this.seccionAlgoritmo = seccionAlgoritmo;
    }

    public Nodo nodoConBloque(String nombreDelBloque){
        return new NodoConcreto(this.seccionBloques.buscarBloque(nombreDelBloque));
    }
}

