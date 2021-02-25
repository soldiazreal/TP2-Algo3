package com.vista.imagenes;

import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import com.tablero.Tablero;
import com.vista.clasesParaVista.VistaPersonaje;
import com.vista.eventos.BotonInstruccionesEventHandler;
import com.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;


public class ContenedorPrincipal extends BorderPane {


    static final DataFormat STRING_LIST = new DataFormat("StringList");
    ListView<String> bloquesDisponibles;
    ListView<String> bloquesAEjecutar;
    BarraDeMenu menuBar;
    Tablero tablero;
    VistaPersonaje vistaPersonaje;

    public ContenedorPrincipal(Stage stage, Tablero tablero) {
        this.tablero = tablero;
        this.setMenu(stage);
        this.setBotonera(stage);
        this.setAlgoritmo(stage);
        Personaje personaje = tablero.getPersonaje();
        this.setReproductor(personaje, stage);
    }

    public void setAlgoritmo(Stage stage) {

        this.bloquesDisponibles = new ListView<>();
        this.bloquesAEjecutar = new ListView<>();
        bloquesDisponibles.setStyle("-fx-border-color: #bb4c14;" + "-fx-border-width: 4");
        bloquesAEjecutar.setStyle("-fx-border-color: #bb4c14;" + "-fx-border-width: 4");

        // Creacion del texto para cada zona
        Label seccionBloquesLbl = new Label("Sección Bloques ");
        seccionBloquesLbl.setFont(new Font("Tahoma", 19));
        seccionBloquesLbl.setStyle("-fx-text-fill: #bb4c14");
        Label seccionAlgoritmosLbl = new Label("  Sección Algoritmo ");
        seccionAlgoritmosLbl.setFont(new Font("Tahoma", 19));
        seccionAlgoritmosLbl.setStyle("-fx-text-fill: #bb4c14");
        Label explicacionLbl = new Label("Arrastra de Sección Bloques a Sección Algoritmo para seleccionar qué se ejecuta");
        explicacionLbl.setStyle("-fx-text-fill: #bb4c14");

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
        general.setPadding(new Insets(10));
        general.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/main/java/com/vista/imagenes/f7.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        general.setBackground(new Background((imagenDeFondo)));
        general.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 4;" +
                        "-fx-border-color: #241802;");

        this.setCenter(general);
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


    public void setBotonera(Stage stage) {

        Button botonCrearPersonalizado = new Button();
        botonCrearPersonalizado.setText("Guardar algoritmo");
        botonCrearPersonalizado.setOnAction(e -> {
            if (bloquesAEjecutar.getItems().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alerta");
                alert.setHeaderText("Hubo un error");
                String mensaje = "No hay ninguna secuencia grabada en Sección Algoritmo!\n\nPor favor, antes de presionar el boton 'Guardar algoritmo' asegurate de haber armado una secuencia.";
                alert.setContentText(mensaje);
                alert.show();
            } else {
                this.bloquesDisponibles.getItems().add("Personalizado");
                this.bloquesAEjecutar.getItems().clear();
                botonCrearPersonalizado.setDisable(true);
            }
        });
        botonCrearPersonalizado.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonReiniciar = new Button();
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setOnAction(e -> this.reiniciarJuego(stage));
        botonReiniciar.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");
        BotonInstruccionesEventHandler botonInstruccionesEventHandler = new BotonInstruccionesEventHandler();
        botonInstrucciones.setOnAction(botonInstruccionesEventHandler);
        botonInstrucciones.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #0a0401;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");
        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(opcionSalirEventHandler);

        VBox contenedor = new VBox(botonInstrucciones, botonCrearPersonalizado, botonReiniciar, botonSalir);
        contenedor.setSpacing(15);
        contenedor.setPadding(new Insets(25));
        contenedor.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/main/java/com/vista/imagenes/f13.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background((imagenDeFondo)));
        contenedor.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 4;" +
                        "-fx-border-color: #3e2302;");

        this.setLeft(contenedor);
    }

    public void setReproductor(Personaje personaje, Stage stage) {
        VBox contenedor = this.crearVistaPersonaje(personaje);

        //creacion de bloques
        tablero.agregarBloque("BajarLapiz", 0);
        tablero.agregarBloque("MoverDerecha", 1);
        tablero.agregarBloque("MoverDerecha", 2);
        tablero.agregarBloque("MoverArriba", 3);
        tablero.agregarBloque("MoverIzquierda", 4);
        tablero.agregarBloque("MoverIzquierda", 5);
        tablero.agregarBloque("MoverIzquierda", 6);
        tablero.agregarBloque("MoverAbajo", 7);
        tablero.agregarBloque("MoverAbajo", 8);
        tablero.agregarBloque("MoverDerecha", 9);
        tablero.agregarBloque("MoverDerecha", 10);
        tablero.agregarBloque("MoverDerecha", 11);
        tablero.agregarBloque("MoverDerecha", 12);
        tablero.agregarBloque("MoverArriba", 13);
        tablero.agregarBloque("MoverArriba", 14);
        tablero.agregarBloque("MoverArriba", 15);
        tablero.agregarBloque("MoverIzquierda", 16);
        tablero.agregarBloque("LevantarLapiz", 17);
        tablero.agregarBloque("MoverIzquierda", 18);
        tablero.agregarBloque("MoverIzquierda", 19);
        tablero.agregarBloque("MoverIzquierda", 20);
        tablero.agregarBloque("BajarLapiz", 21);
        tablero.agregarBloque("MoverIzquierda", 22);
        tablero.agregarBloque("MoverAbajo", 23);
        tablero.agregarBloque("MoverAbajo", 24);
        tablero.agregarBloque("MoverAbajo", 25);
        tablero.agregarBloque("MoverAbajo", 26);
        tablero.agregarBloque("MoverDerecha", 27);
        tablero.agregarBloque("MoverAbajo", 28);
        tablero.agregarBloque("MoverAbajo", 29);
        tablero.agregarBloque("MoverAbajo", 30);
        tablero.agregarBloque("MoverAbajo", 31);
        tablero.agregarBloque("MoverAbajo", 32);
        tablero.agregarBloque("MoverAbajo", 33);
        tablero.agregarBloque("MoverAbajo", 34);
        //se agregaron todos

        Button reproducir = new Button("reproducir");
        reproducir.setOnAction(e -> {
            tablero.iniciarAlgoritmo();
            vistaPersonaje.getTimeline().play();
            reproducir.setDisable(true);
        });
        reproducir.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button reestablecer = new Button("reestablecer");
        reestablecer.setOnAction(e -> {
            reproducir.setDisable(false);
            vistaPersonaje.getTimeline().stop();
            vistaPersonaje.reiniciarVista();
            this.reiniciarSimulacion(stage);
        });
        reestablecer.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #441509;" +
                "-fx-background-color: #eaaf95;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        HBox botonera = new HBox(reproducir, reestablecer);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(15);
        botonera.setPadding(new Insets(25));

        contenedor.getChildren().addAll(botonera);

        this.setRight(contenedor);
    }

    public VBox crearVistaPersonaje(Personaje personaje) {
        Canvas canvasCentral = new Canvas(500, 500);
        VistaPersonaje vistaPersonaje = new VistaPersonaje(personaje, canvasCentral);
        personaje.addListener(vistaPersonaje);
        this.vistaPersonaje = vistaPersonaje;

        vistaPersonaje.iniciarVista();
        VBox contenedorCanvas = new VBox(canvasCentral);
        contenedorCanvas.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 7;" +
                        "-fx-border-color: #bb4c14;");

        VBox contenedor = new VBox(contenedorCanvas);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(20);
        contenedor.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/com/vista/imagenes/f7.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));

        return contenedor;
    }

    public void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    public void reiniciarSimulacion(Stage stage) {
        Personaje personajeNuevo = new Personaje(new Posicion(0, 0), new SeccionDibujo());
        tablero.reiniciar(personajeNuevo);
        this.setReproductor(personajeNuevo, stage);
    }

    public void reiniciarJuego(Stage stage) {
        this.tablero = new Tablero();
        this.setMenu(stage);
        this.setBotonera(stage);
        Personaje personaje = tablero.getPersonaje();
        this.setReproductor(personaje, stage);
    }
}











