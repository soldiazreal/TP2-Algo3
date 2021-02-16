package com.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    public void handle (ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Block Us");
        String mensaje = "Esta es una app de aprendizaje de programación desarrollada por los siguientes estudiantes: \n - Avendaño, Franz\n - Demarchi, Lucas\n - Diaz Real, Sol\n - Vargas, Marcos\n\n Con el uso de Java 15, JavaFX 15.";
        alert.setContentText(mensaje);
        alert.show();
    }

}
