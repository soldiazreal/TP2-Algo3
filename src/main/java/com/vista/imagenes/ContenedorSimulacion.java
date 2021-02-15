package com.vista.imagenes;

import com.tablero.Tablero;
import com.vista.eventos.BotonCrearPersonalizadoHandler;
import com.vista.eventos.BotonReproducirHandler;
import com.vista.eventos.BotonVolverHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ContenedorSimulacion extends BorderPane {

    Scene escenaAnterior;
    Tablero tablero;

    public ContenedorSimulacion (Stage stage, Tablero tablero, Scene escenaAnterior) {
        this.tablero = tablero;
        this.setDibujo(stage, tablero);
        this.escenaAnterior = escenaAnterior;
    }

    public void setBotonera (Stage stage, Tablero tablero) {

        Button botonParar = new Button();
        botonParar.setText("Parar");
        BotonReproducirHandler botonReproducirHandler = new BotonReproducirHandler(stage, new Scene(new ContenedorSimulacion(stage, tablero, escenaAnterior)));
        botonParar.setOnAction(botonReproducirHandler);

        Button botonVolver = new Button();
        botonVolver.setText("Volver");
        BotonVolverHandler botonVolverHandler = new BotonVolverHandler();
        botonVolver.setOnAction(botonVolverHandler);

        HBox contenedorHorizontal = new HBox(botonVolver, botonParar);
        contenedorHorizontal.setSpacing(100);
        contenedorHorizontal.setPadding(new Insets(15));

        this.setBottom(contenedorHorizontal);

    }

    public void setDibujo (Stage stage, Tablero tablero) {
        Pane seccionDibujado = new Pane();
        //PARTE DE LINEAS
        List<Line> lines = new ArrayList<>();

        for(int i = 5; i <= 405; i+= 100) {
            for (int j = 5; j <= 205; j += 100) {
                Circle circle = new Circle();
                circle.setCenterX(i);
                circle.setCenterY(j);
                circle.setRadius(3);
                seccionDibujado.getChildren().add(circle);
            }
        }

        for(int i = 5; i < 405; i+= 100) {
            for(int j = 5; j <= 205; j+= 100) {
                Line line = new Line();
                line.setStartX(i);
                line.setStartY(j);
                line.setEndX(i + 100);
                line.setEndY(j );
                line.setVisible(true);
                lines.add(line);
                seccionDibujado.getChildren().add(line);
            }
        }
        for(int i = 5; i <= 405; i+= 100) {
            for(int j = 5; j < 205; j+= 100) {
                Line line = new Line();
                line.setStartX(i);
                line.setStartY(j);
                line.setEndX(i );
                line.setEndY(j + 100);
                line.setVisible(true);
                lines.add(line);
                seccionDibujado.getChildren().add(line);
            }
        }

        //la goma de borrar lineas magica
        for(int i = 0; i < 0; i++){
            lines.get(i).setVisible(false);
        }
        //Termina creacion de lineas

        seccionDibujado.setMaxSize(410, 210); //SECCION DE LAS LINEAS
        VBox escenaSimulacion = new VBox(seccionDibujado);
        this.setCenter(escenaSimulacion);
    }
}
