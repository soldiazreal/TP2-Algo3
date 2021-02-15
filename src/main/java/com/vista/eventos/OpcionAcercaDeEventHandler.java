package com.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    public void handle (ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("ejemplo de mensaje de alerta");
        String mensaje = "Esta es una app de aprendizaje de programación";
        alert.setContentText(mensaje);
        alert.show();
    }

}
