package com.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonInstruccionesEventHandler implements EventHandler<ActionEvent> {

    public void handle (ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText("Block Us: ¿Cómo se usa?");
        String mensaje = "El principal objetivo de esta aplicación es introducir al usuario al mundo de la programación de una manera más amigable. Para ello el mismo podrá mover a nuestro amigo Blocky en cualquier dirección dentro del terreno.\n\nPara poder decirle a Blocky qué movimientos realizar usted debe generar la rutina arrastrando el bloque que desea colocar de 'Sección Bloques' a 'Sección Algoritmo' y una vez esté lista la secuencia deseada solo deberá clickear en el boton 'Reproducir'.\n\nAdemás de lo nombrado, usted podrá crear un bloque personalizado, el cual pueder realizar la secuencia de acciones que desee valiendo como un único bloque. Para crearlo debe dejar la secuencia deseada en 'Sección Algoritmo' como si estuviese creando la secuencia para mover a Blocky solo que deberá clickear unicamente el botón 'Guardar algoritmo' y luego armar la rutina principal. Dato importante, el bloque personalizado no se verá en la lista de 'Sección Bloques' hasta que sea creado por primera vez.";
        alert.setContentText(mensaje);
        alert.show();
    }
}
