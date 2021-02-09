package com.tablero;

import  com.bloques.Bloque;
import com.personaje.Personaje;
import com.posicion.Posicion;

public class Tablero {

    private SeccionBloques seccionBloques = new SeccionBloques();
    private SeccionAlgoritmo seccionAlgoritmo = new SeccionAlgoritmo();

    public void agregarBloque (String unNombre, int unIndice) {
        Bloque bloqueRecibido = seccionBloques.buscarBloque(unNombre);
        seccionAlgoritmo.agregarBloqueEnPosicion(bloqueRecibido, unIndice);
    }

    public void removerBloque (int unIndice) {
        seccionAlgoritmo.removerBloqueDePosicion(unIndice);
    }

    public void iniciarAlgoritmo () {
        seccionAlgoritmo.ejecutar(new Personaje(new Posicion(0,0), new SeccionDibujo()));
    }

    public void reiniciarPrograma () {
        this.seccionBloques = new SeccionBloques();
        this.seccionAlgoritmo = new SeccionAlgoritmo();
    }

    //ojo con esto, es peligroso pero no quedaba otra por el momento
    public void setSeccionBloquesYAlgoritmos (SeccionBloques seccionBloques, SeccionAlgoritmo seccionAlgoritmo)  {
        this.seccionBloques = seccionBloques;
        this.seccionAlgoritmo = seccionAlgoritmo;
    }
}

