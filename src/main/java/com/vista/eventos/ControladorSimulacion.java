package com.vista.eventos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorSimulacion extends BorderPane {

    public void mostrarSimulacion() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox cuadricula = new VBox();
        Scene escena = new Scene(cuadricula, 1400, 900);
        Button volver = new Button("Volver");

        volver.setOnAction(e -> {
            stage.close();
        });

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


        cuadricula.getChildren().addAll(seccionDibujado, volver);
        stage.setScene(escena);
        stage.showAndWait();
    }
}
