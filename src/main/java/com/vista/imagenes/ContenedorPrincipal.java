package com.vista.imagenes;

import com.tablero.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Canvas canvasCentral;
    BarraDeMenu menuBar;
    VBox contenedorCentral;

    public ContenedorPrincipal (Stage stage, Tablero tablero) {
        this.setMenu(stage);
    }

    public void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }


}
