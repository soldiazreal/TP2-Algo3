package com.tablero;

import  com.bloques.Bloque;
import com.acciones.BajarLapiz;
import com.bloques.Individual;
import com.bloques.Secuencial;
import com.factory.CrearBloqueIndividual;
import com.personaje.Personaje;
import com.posicion.Posicion;

public class Tablero {

    // HABLAR CON SEBA SOBRE LA "INSTANCIA" DE UNA INTERFAZ QUE SEA CAPAZ DE SABER QUE ES UN BLOQUE

    private SeccionBloques seccionBloques = new SeccionBloques();
    private SeccionAlgoritmo seccionAlgoritmo = new SeccionAlgoritmo();

    public void agregarBloque (String unNombre, int unIndice) {
        //tengo que pedir un bloque a seccion bloques
        Bloque bloqueRecibido = seccionBloques.buscarBloque(unNombre);
        //le doy ese bloque y el indice en donde va..
        seccionAlgoritmo.agregarBloqueEnPosicion(bloqueRecibido, unIndice);
    }

    public void removerBloque (String unNombre, int unIndice) {
        seccionAlgoritmo.removerBloqueDePosicion(unNombre, unIndice);
    }

    public void iniciarAlgoritmo () {
        seccionAlgoritmo.ejecutar(new Personaje(new Posicion(0,0), new SeccionDibujo()));
    }

    public void reiniciarPrograma () {
        this.seccionBloques = new SeccionBloques();
        this.seccionAlgoritmo = new SeccionAlgoritmo();
    }
}

