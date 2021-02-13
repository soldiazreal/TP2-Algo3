package com.vista.imagenes;

import com.tablero.Tablero;
import com.vista.eventos.BotonCrearPersonalizadoHandler;
import com.vista.eventos.BotonReproducirHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Canvas canvasCentral;
    BarraDeMenu menuBar;
    VBox contenedorCentral;

    public ContenedorPrincipal (Stage stage, Tablero tablero) {
        this.setMenu(stage);
        ContenedorPersonalizado contenedorPersonalizado = new ContenedorPersonalizado();
        Scene escenaPersonalizado = new Scene(contenedorPersonalizado, 640, 480);
        ContenedorSimulacion contenedorSimulacion = new ContenedorSimulacion();
        Scene escenaSimulacion = new Scene(contenedorSimulacion, 640, 480);
        this.setBotonera(stage, escenaPersonalizado, escenaSimulacion);

    }

    public void setBotonera(Stage stage, Scene escenaPersonalizado, Scene escenaSimulacion) {
        Button botonCrearPersonalizado = new Button();
        botonCrearPersonalizado.setText("Crear bloque personalizado");
        BotonCrearPersonalizadoHandler crearPersonalizadoHandler = new BotonCrearPersonalizadoHandler(stage, escenaPersonalizado);
        botonCrearPersonalizado.setOnAction(crearPersonalizadoHandler);

        Button botonReproducir = new Button();
        botonReproducir.setText("Reproducir simulación!");
        BotonReproducirHandler botonReproducirHandler = new BotonReproducirHandler(stage, escenaSimulacion);
        botonReproducir.setOnAction(botonReproducirHandler);

        Button botonReiniciar = new Button();
        botonReiniciar.setText("Reiniciar programa");

        botonReiniciar.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
       // botonReiniciar.setStyle("-fx-background-color: #00ff00");
       // botonReiniciar.setStyle("-fx-font-size: 2em; ");
        botonReiniciar.setStyle("-fx-text-fill: #ff0000");

        HBox contenedorHorizontal = new HBox(botonCrearPersonalizado, botonReproducir, botonReiniciar);
        contenedorHorizontal.setSpacing(300);
        contenedorHorizontal.setPadding(new Insets(15));

        this.setBottom(contenedorHorizontal);
    }

    public void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }


    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }


}
