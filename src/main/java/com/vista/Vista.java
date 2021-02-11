package com.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Vista extends Application {
    @Override
    public void start (Stage stage) throws Exception{
        stage.setTitle("titulo");

        StackPane layout = new StackPane();
        Button boton = new Button();
        boton.setText("accept");

        layout.getChildren().add(boton);

        Scene escena = new Scene(layout);
        stage.setScene(escena);
        stage.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}
