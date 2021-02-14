package com.test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InterfazGrafica extends Application {
    private final Image bgImage = new Image("file:src/main/java/com/images/fondo.jpg");
    private final StackPane container = new StackPane();
    private final Scene scene = new Scene(container);
    private final Text label  = new Text("Block us");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        // Asigna un titulo y dimensiones al "stage"
        primaryStage.setTitle("Block Us");
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(160);

        // Agrego imagen de fondo a la ventana

        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(800);
        imageView.setFitWidth(1600);
        container.getChildren().add(imageView);
        // Agrego texto a la ventana

        label.setFill(Color.BLACK);
        label.setFont(Font.font("Algerian", FontWeight.BOLD, 100));
        container.setAlignment(Pos.CENTER);
        container.getChildren().add(label);


            // Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
