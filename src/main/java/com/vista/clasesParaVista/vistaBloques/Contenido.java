package com.vista.clasesParaVista.vistaBloques;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Contenido extends StackPane {
    ImageView imagenes;
    Label nombre = new Label("");

    public Contenido(ImageView imagen){
        this.getChildren().add(imagen);
        this.imagenes = imagen;
    }

    public ImageView getImageView(){
        return this.imagenes;
    }

    public void agregarNombre(Label nombre){
        this.nombre = nombre;
        nombre.setStyle("-fx-text-fill: #FFFFFF;"+"-fx-font-weight: bold;");
        this.getChildren().add(nombre);
    }

    public Contenido copiaContenido(){
        Contenido copia = new Contenido(new ImageView(this.imagenes.getImage()));
        Label nombre = new Label(this.nombre.getText());
        copia.agregarNombre(nombre);
        return copia;
    }
}
