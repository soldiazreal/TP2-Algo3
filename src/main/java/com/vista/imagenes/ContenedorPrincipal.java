package com.vista.imagenes;

import com.tablero.Tablero;
import com.vista.eventos.BotonCrearPersonalizadoHandler;
import com.vista.eventos.BotonReiniciarHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ContenedorPrincipal extends BorderPane {

    static final DataFormat STRING_LIST = new DataFormat("StringList");

    Canvas canvasCentral;
    BarraDeMenu menuBar;
    VBox contenedorCentral;
    Tablero tablero;

    public ContenedorPrincipal (Stage stage, Tablero tablero) {
        this.tablero = tablero;
        this.setMenu(stage);
        ContenedorPersonalizado contenedorPersonalizado = new ContenedorPersonalizado();
        Scene escenaPersonalizado = new Scene(contenedorPersonalizado, 640, 480);
        this.setAlgoritmo(stage);
        this.setDibujo(stage);
        this.setBotonera(stage, escenaPersonalizado);
        Image imagen = new Image("file:src/main/java/com/vista/imagenes/fondo.jpg");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background((imagenDeFondo)));
    }

    public void setBotonera(Stage stage, Scene escenaPersonalizado) {

        Button botonCrearPersonalizado = new Button();
        botonCrearPersonalizado.setText("Personalizado");
        BotonCrearPersonalizadoHandler crearPersonalizadoHandler = new BotonCrearPersonalizadoHandler(stage, escenaPersonalizado);
        botonCrearPersonalizado.setOnAction(crearPersonalizadoHandler);

        Button botonReiniciar = new Button();
        botonReiniciar.setText("Reiniciar");
        BotonReiniciarHandler botonReiniciarHandler = new BotonReiniciarHandler(tablero);
        botonReiniciar.setOnAction(botonReiniciarHandler);
        botonReiniciar.setStyle("-fx-border-color: #000000; -fx-border-width: 5px;");
        // botonReiniciar.setStyle("-fx-background-color: #00ff00");
        // botonReiniciar.setStyle("-fx-font-size: 2em; ");
        botonReiniciar.setStyle("-fx-text-fill: #ff0000");

        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");

        VBox contenedor = new VBox(botonInstrucciones, botonCrearPersonalizado, botonReiniciar, botonSalir);
        contenedor.setSpacing(15);
        contenedor.setPadding(new Insets(25));
        contenedor.setAlignment(Pos.CENTER);

        this.setLeft(contenedor);
    }

    public void setDibujo(Stage stage) {

        Pane seccionDibujado = new Pane();
        //PARTE DE LINEAS
        List<Line> lines = new ArrayList<>();

        for(int i = 5; i <= 405; i+= 100) {
            for (int j = 5; j <= 405; j += 100) {
                Circle circle = new Circle();
                circle.setCenterX(i);
                circle.setCenterY(j);
                circle.setRadius(3);
                seccionDibujado.getChildren().add(circle);
            }
        }

        for(int i = 5; i < 405; i+= 100) {
            for(int j = 5; j <= 405; j+= 100) {
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
            for(int j = 5; j < 405; j+= 100) {
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

        seccionDibujado.setMaxSize(410, 410); //SECCION DE LAS LINEAS

        HBox dibujo = new HBox(seccionDibujado);
        dibujo.setAlignment(Pos.CENTER);
        dibujo.setPadding(new Insets(25));

        Button botonReproducir = new Button("Reproducir");
        HBox botonera = new HBox(botonReproducir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setPadding(new Insets(15));

        VBox contenedor = new VBox(dibujo, botonera);
        //contenedor.setPadding(new Insets(15));
        contenedor.setSpacing(20);
        contenedor.setAlignment(Pos.CENTER);
        //contenedor.setAlignment(Pos.CENTER);
        this.setRight(contenedor);
    }

    public void setAlgoritmo(Stage stage) {

        ListView<String> bloquesDisponibles = new ListView<>();
        ListView<String> bloquesAEjecutar = new ListView<>();

        // Creacion del texto para cada zona
        Label seccionBloquesLbl = new Label("Seccion Bloques ");
        seccionBloquesLbl.setFont(new Font("Tahoma", 19));
        Label seccionAlgoritmosLbl = new Label("Seccion Algoritmos ");
        seccionAlgoritmosLbl.setFont(new Font("Tahoma", 19));
        Label explicacionLbl = new Label("Arrastra de seccion bloques a seccion algoritmos para seleccionar que se ejecuta");

        // Seleccion de como se ven las areas
        bloquesDisponibles.setPrefSize(200, 350);
        bloquesAEjecutar.setPrefSize(200, 350);

        // Agregando los bloques a la Source List
        bloquesDisponibles.getItems().addAll(this.getBloqueList());

        // Permitiendo multiple seleccion en listas
        bloquesDisponibles.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        bloquesAEjecutar.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Agregandoe el evento del mouse y los handlers para los disponibles
        bloquesDisponibles.setOnDragDetected(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                dragDetected(event, bloquesDisponibles);
            }
        });

        bloquesDisponibles.setOnDragOver(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragOver(event, bloquesDisponibles);
            }
        });

        // Agregar mouse para los event handlers para el objetivo
        bloquesAEjecutar.setOnDragDetected(new EventHandler <MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                dragDetected(event, bloquesAEjecutar);
            }
        });

        bloquesAEjecutar.setOnDragOver(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragOver(event, bloquesAEjecutar);
            }
        });

        bloquesAEjecutar.setOnDragDropped(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragDropped(event, bloquesAEjecutar);
            }
        });

        bloquesAEjecutar.setOnDragDone(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragDone(event, bloquesAEjecutar);
                removeSelectedBloque(bloquesAEjecutar);
            }
        });



        Button botonReiniciar = new Button();
        botonReiniciar.setText("Reiniciar");
        BotonReiniciarHandler botonReiniciarHandler = new BotonReiniciarHandler(tablero);
        botonReiniciar.setOnAction(botonReiniciarHandler);
        botonReiniciar.setStyle("-fx-border-color: #000000; -fx-border-width: 5px;");
       // botonReiniciar.setStyle("-fx-background-color: #00ff00");
       // botonReiniciar.setStyle("-fx-font-size: 2em; ");
        botonReiniciar.setStyle("-fx-text-fill: #ff0000");

        HBox textos = new HBox();
        textos.getChildren().addAll(seccionBloquesLbl, seccionAlgoritmosLbl);
        textos.setSpacing(80);
        textos.setPadding(new Insets(10));
        textos.setAlignment(Pos.CENTER);

        HBox listas = new HBox(bloquesDisponibles, bloquesAEjecutar);
        listas.setSpacing(50);
        listas.setAlignment(Pos.CENTER);

        HBox explicacion =  new HBox(explicacionLbl);
        explicacion.setAlignment(Pos.CENTER);

        VBox general = new VBox(textos, listas, explicacion);
        general.setSpacing(22);
        //general.setAlignment(Pos.CENTER);
        general.setPadding(new Insets(10));
        general.setAlignment(Pos.CENTER);
        /*listas.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: blue;");
*/
        this.setCenter(general);

    }

    public void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }


    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }








    private ObservableList<String> getBloqueList()
    {
        ObservableList<String> list = FXCollections.<String>observableArrayList();

        String moverDerecha = "Derecha";
        String moverIzquierda = "Izquierda";
        String moverArriba = "Arriba";
        String moverAbajo = "Abajo";

        list.addAll(moverDerecha,moverIzquierda,moverArriba,moverAbajo);

        return list;
    }

    private void dragDetected(MouseEvent event, ListView<String> listView)
    {
        // Estando seguro de que un objeto fue seleccionado
        int selectedCount = listView.getSelectionModel().getSelectedIndices().size();

        if (selectedCount == 0)
        {
            event.consume();
            return;
        }

        // Iniciando el drag y drop
        Dragboard dragboard = listView.startDragAndDrop(TransferMode.COPY);

        // Poniendo los items seleccionados en la dragboard
        ArrayList<String> selectedItems = this.getSelectedBloque(listView);

        ClipboardContent content = new ClipboardContent();
        content.put(STRING_LIST, selectedItems);

        dragboard.setContent(content);
        event.consume();
    }

    private void dragOver(DragEvent event, ListView<String> listView)
    {
        // Si la drag board tiene una ITEM_LIST y no esta siendo arrastrada
        // sobre si misma, aceptamos el MOVE transfer mode
        Dragboard dragboard = event.getDragboard();

        if (event.getGestureSource() != listView && dragboard.hasContent(STRING_LIST))
        {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    @SuppressWarnings("unchecked")
    private void dragDropped(DragEvent event, ListView<String> listView)
    {
        boolean dragCompleted = false;

        // Transfiriendo los datos
        Dragboard dragboard = event.getDragboard();

        if(dragboard.hasContent(STRING_LIST))
        {
            ArrayList<String> list = (ArrayList<String>)dragboard.getContent(STRING_LIST);
            listView.getItems().addAll(list);
            // Transferencia de datos exitosa
            dragCompleted = true;
        }

        // Transferencia de datos no es exitosa
        event.setDropCompleted(dragCompleted);
        event.consume();
    }

    private void dragDone(DragEvent event, ListView<String> listView)
    {
        // Esto habria que sacarlo estas removiendo el item no queremos hacer eso
        TransferMode tm = event.getTransferMode();

        if (tm == TransferMode.MOVE)
        {
            removeSelectedBloque(listView);
        }

        event.consume();
    }

    private ArrayList<String> getSelectedBloque(ListView<String> listView)
    {
        // Devolviendo la lista de Bloques seleccionados en una ArrayList, asi es
        // serializable y se pueda guardar en una Dragboard.
        ArrayList<String> list = new ArrayList<String>(listView.getSelectionModel().getSelectedItems());

        return list;
    }

    private void removeSelectedBloque(ListView<String> listView)
    {
        // Metiendo todos los Bloques en una lista separada para no tener el problema de lista compartida
        List<String> selectedList = new ArrayList<>();

        for(String string : listView.getSelectionModel().getSelectedItems())
        {
            selectedList.add(string);
        }

        // Limpiando la seleccion
        listView.getSelectionModel().clearSelection();
        // Removiendo items de la lista seleccionada
        listView.getItems().removeAll(selectedList);
    }
}


