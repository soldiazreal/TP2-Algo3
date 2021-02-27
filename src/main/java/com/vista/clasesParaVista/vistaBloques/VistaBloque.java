package com.vista.clasesParaVista.vistaBloques;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class VistaBloque extends VBox {


    public abstract void asignarSiguiente(VistaBloque siguiente);

    protected abstract void asignarAnterior(VistaBloque anterior);

    public abstract VistaBloque ultimoSiguiente();

    public abstract boolean esNulo();

    public abstract VistaBloque copia();


}
