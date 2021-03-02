package com.vista.clasesParaVista.vistaBloques;

import com.nodos.Nodo;
import com.nodos.NodoNulo;
import javafx.scene.layout.VBox;

public abstract class VistaBloque extends VBox {

    Nodo nodo = new NodoNulo();

    public Nodo getNodo(){
        return nodo;
    }


    public abstract void asignarSiguiente(VistaBloque siguiente);

    protected abstract void asignarAnterior(VistaBloque anterior);

    public abstract VistaBloque ultimoSiguiente();

    public abstract boolean esNulo();

    public abstract void asignarASiguienteUnNulo();

}
