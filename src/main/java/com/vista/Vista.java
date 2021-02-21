package com.vista;

import com.tablero.Tablero;
import com.vista.imagenes.ContenedorBienvenidos;
import com.vista.imagenes.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Vista extends Application {
    @Override
    public void start (Stage stage) throws Exception{
        stage.setTitle("Block Us");

        Tablero tablero = new Tablero();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, tablero);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1400, 900);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1400, 900);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}
