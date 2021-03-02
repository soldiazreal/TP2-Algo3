package com.vista.clasesParaVista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageGuardarAlgoritmo {
    private String data;
    private final int maxLongitudNombre = 13;

    public void showStage() {
        Stage stage = new Stage();
        stage.setTitle("Personalizado");
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox contenedor = new VBox();
        Label instruccion = new Label("Ingresá el nombre");
        instruccion.setFont(new Font("Tahoma", 19));
        instruccion.setStyle("-fx-text-fill: #ffffff");
        contenedor.setPrefSize(300, 300);
        contenedor.setStyle("-fx-background-color: #05c0dc;");
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(25));
        Scene escena = new Scene(contenedor);
        TextField contendorString = new TextField();
        Button botonGuardar = new Button("Guardar nombre");
        botonGuardar.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        botonGuardar.setOnAction(e -> {
            if (contendorString.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Ingresaste un nombre vacío!");
                String mensaje = "Lo sentimos, el nombre debe ser válido. Por favor ingresalo de nuevo.";
                alert.setContentText(mensaje);
                alert.show();
            } else if (contendorString.getText().length() > this.maxLongitudNombre){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Ingresaste un nombre muy largo, el nombre debe tener un maximo de "+maxLongitudNombre+" caracteres");
                String mensaje = "Lo sentimos, el nombre debe ser válido. Por favor ingresalo de nuevo.";
                alert.setContentText(mensaje);
                alert.show();

            } else {
                data = contendorString.getText();
                stage.close();
            }
        });

        contenedor.getChildren().addAll(instruccion, contendorString, botonGuardar);
        stage.setScene(escena);
        stage.showAndWait();
    }

    public String getData() {
        return data;
    }
}
