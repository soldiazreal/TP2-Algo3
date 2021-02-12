package com.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler (Stage stage, MenuItem opcionPantallaCompleta) {
        this.opcionPantallaCompleta = opcionPantallaCompleta;
        this.stage = stage;
    }

    public void handle (ActionEvent actionEvent){
        if (!stage.isFullScreen()){
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }

}
