package com.vista.clasesParaVista.vistBloquesAEjecutar;

import com.tablero.Tablero;
import com.vista.clasesParaVista.vistaBloques.Contenido;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueInicio;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VistaBloquesAEjecutar extends VBox {
    public VistaBloquesAEjecutar (Tablero tablero){

        this.setSpacing(20);

        this.setPrefSize(250, 460);

        //Agregando bloque Inicial a Bloques a Ejecutar
        this.getChildren().add(new VistaBloqueInicio(new Contenido(new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/BloqueInicio.PNG"))), tablero.getPrimerNodo()));
    }
}
