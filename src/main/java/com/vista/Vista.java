package com.vista;

import com.tablero.Tablero;
import com.vista.imagenes.ContenedorBienvenidos;
import com.vista.imagenes.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Vista extends Application {
    @Override
    public void start (Stage stage) throws Exception{
        stage.setTitle("titulo");
/*
        StackPane layout = new StackPane();
        Button boton = new Button();
        boton.setText("accept");

        layout.getChildren().add(boton);

        Scene escena = new Scene(layout);
        stage.setScene(escena);
        stage.show();
  */
        Tablero tablero = new Tablero();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, tablero);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1024, 720);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1024, 720);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}
