package com.vista.clasesParaVista.vistaBloques;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Contenido extends StackPane {
    ImageView imagenes;

    public Contenido(ImageView imagen){
        this.getChildren().add(imagen);
        this.imagenes = imagen;
    }

    public ImageView getImageView(){
        return this.imagenes;
    }

    public void agregarNombre(Label nombre){
        this.getChildren().add(nombre);
    }
}
