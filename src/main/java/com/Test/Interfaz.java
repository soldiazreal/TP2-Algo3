package com.Test;

import java.util.ArrayList;
import java.util.List;

import java.lang.String;
import com.acciones.MoverAbajo;
import com.acciones.MoverArriba;
import com.acciones.MoverDerecha;
import com.acciones.MoverIzquierda;
import com.bloques.Individual;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Interfaz extends Application
{
    // Creacion de seccion bloques y de seccion algoritmos (sus listas)
    ListView<String> bloquesDisponibles = new ListView<>();
    ListView<String> bloquesAEjecutar = new ListView<>();
    LinesTest grid = new LinesTest();
    // Creacion de zona de dibujo (la parte visual)

    //TextArea loggingArea = new TextArea("");
    Pane seccionDibujado = new Pane();

    static final DataFormat STRING_LIST = new DataFormat("StringList");

    public static void main(java.lang.String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        //PARTE DE LINEAS
        List<Line> lines = new ArrayList<>();

        for(int i = 5; i <= 405; i+= 100) {
            for (int j = 5; j <= 205; j += 100) {
                Circle circle = new Circle();
                circle.setCenterX(i);
                circle.setCenterY(j);
                circle.setRadius(3);
                seccionDibujado.getChildren().add(circle);
            }
        }

        for(int i = 5; i < 405; i+= 100) {
            for(int j = 5; j <= 205; j+= 100) {
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
            for(int j = 5; j < 205; j+= 100) {
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

        // Creacion del texto para cada zona
        Label seccionBloquesLbl = new Label("Seccion Bloques: ");
        Label seccionAlgoritmosLbl = new Label("Seccion Algoritmos: ");
        Label explicacionLbl = new Label("Arrastra de seccion bloques a seccion algoritmos para seleccionar que se ejecuta");

        // Seleccion de como se ven las areas
        bloquesDisponibles.setPrefSize(200, 200);
        bloquesAEjecutar.setPrefSize(200, 200);
        seccionDibujado.setMaxSize(410, 210); //SECCION DE LAS LINEAS

        // Agregando los bloques a la Source List
        bloquesDisponibles.getItems().addAll(this.getBloqueList());

        // Permitiendo multiple seleccion en listas
        bloquesDisponibles.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        bloquesAEjecutar.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        // Agregando los Labels y Views al Pane
        pane.add(explicacionLbl, 0, 0, 3, 1);
        pane.addRow(1, seccionBloquesLbl, seccionAlgoritmosLbl);
        pane.addRow(2, bloquesDisponibles, bloquesAEjecutar);

        // Agregandoe el evento del mouse y los handlers para los disponibles
        bloquesDisponibles.setOnDragDetected(new EventHandler <MouseEvent>()
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

        bloquesDisponibles.setOnDragDropped(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragDropped(event, bloquesDisponibles);
            }
        });

        bloquesDisponibles.setOnDragDone(new EventHandler <DragEvent>()
        {
            public void handle(DragEvent event)
            {
                dragDone(event, bloquesDisponibles);
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
            }
        });

        VBox root = new VBox();
        // Agregando el Pane y la seccionDibujado a la VBox
        root.getChildren().addAll(pane, seccionDibujado);
        // Estilo de la VBox
        root.setStyle(
                "-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Creando la scene
        Scene scene = new Scene(root);
        // Agregando la Scene al Stage
        stage.setScene(scene);
        // Poniendo el titulo
        stage.setTitle("Block US");
        // Display del stage
        stage.show();
    }

    // Create the Bloque List
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