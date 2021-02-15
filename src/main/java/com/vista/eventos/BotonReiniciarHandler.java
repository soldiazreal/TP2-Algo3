package com.vista.eventos;

import com.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonReiniciarHandler implements EventHandler<ActionEvent> {

    Tablero tablero;

    public BotonReiniciarHandler (Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void handle (ActionEvent actionEvent) {
        this.tablero.reiniciarPrograma();
    }
}
