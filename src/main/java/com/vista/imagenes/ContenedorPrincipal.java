package com.vista.imagenes;

import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import com.tablero.Tablero;
import com.vista.clasesParaVista.StageGuardarAlgoritmo;
import com.vista.clasesParaVista.VistaPersonaje;
import com.vista.clasesParaVista.vistBloquesAEjecutar.VistaBloquesAEjecutar;
import com.vista.clasesParaVista.vistaBloques.Contenido;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueDisponible;
import com.vista.clasesParaVista.vistaSeccionBloques.VistaSeccionBloques;
import com.vista.eventos.BotonInstruccionesEventHandler;
import com.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.text.Font;

public class ContenedorPrincipal extends BorderPane {


    static final DataFormat STRING_LIST = new DataFormat("StringList");
    ScrollPane bloquesDisponibles = new ScrollPane();
    VistaSeccionBloques vistaSeccionBloques;
    VistaBloquesAEjecutar bloquesAEjecutar;
    BarraDeMenu menuBar;
    Tablero tablero;
    VistaPersonaje vistaPersonaje;
    HBox listas = new HBox();

    public ContenedorPrincipal(Stage stage, Tablero tablero) {
        this.tablero = tablero;
        this.setMenu(stage);
        this.setBotonera(stage);
        this.setAlgoritmo(stage);
        Personaje personaje = tablero.getPersonaje();
        this.setReproductor(personaje, stage);
    }

    public void setAlgoritmo(Stage stage) {
        ScrollPane paneBloquesAEjecutar = new ScrollPane();
        bloquesAEjecutar = new VistaBloquesAEjecutar(this.tablero);
        paneBloquesAEjecutar.setContent(bloquesAEjecutar);
        paneBloquesAEjecutar.setStyle("-fx-border-color: #e84daf;" + "-fx-border-width: 4;");
        this.vistaSeccionBloques = new VistaSeccionBloques(this.tablero);
        bloquesDisponibles.setContent(vistaSeccionBloques);
        bloquesDisponibles.setStyle("-fx-border-color: #e84daf;" + "-fx-border-width: 4;");

        // Creacion del texto para cada zona
        Label seccionBloquesLbl = new Label("   Sección Bloques ");
        seccionBloquesLbl.setFont(new Font("Tahoma", 19));
        seccionBloquesLbl.setStyle("-fx-text-fill: #ffffff");
        Label seccionAlgoritmosLbl = new Label("      Sección Algoritmo ");
        seccionAlgoritmosLbl.setFont(new Font("Tahoma", 19));
        seccionAlgoritmosLbl.setStyle("-fx-text-fill: #ffffff");
        Label explicacionLbl = new Label("Arrastra de Sección Bloques a Sección Algoritmo para seleccionar qué se ejecuta");
        explicacionLbl.setStyle("-fx-text-fill: #ffffff");

        // Seleccion de como se ven las areas
        bloquesDisponibles.setPrefSize(250, 460);

        HBox textos = new HBox();
        textos.getChildren().addAll(seccionBloquesLbl, seccionAlgoritmosLbl);
        textos.setSpacing(104);
        textos.setPadding(new Insets(10));
        textos.setAlignment(Pos.CENTER);

        listas = new HBox(bloquesDisponibles, paneBloquesAEjecutar);
        listas.setSpacing(60);
        listas.setAlignment(Pos.CENTER);

        HBox explicacion = new HBox(explicacionLbl);
        explicacion.setAlignment(Pos.CENTER);

        VBox general = new VBox(textos, listas, explicacion);
        general.setSpacing(22);
        general.setPadding(new Insets(10));
        general.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/main/java/com/vista/imagenes/fondoprincipal.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        general.setBackground(new Background((imagenDeFondo)));
        general.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 4;" +
                        "-fx-border-color: #000000;");

        this.setCenter(general);
    }

    public void setBotonera(Stage stage) {

        Button botonCrearPersonalizado = new Button();
        botonCrearPersonalizado.setText("Guardar algoritmo");

        botonCrearPersonalizado.setOnAction(e -> {
            if (tablero.getPrimerNodo().conseguirSiguiente().esUltimo()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("La sección algoritmo está vacía!");
                String mensaje = "Lo sentimos, tenés que agregar por lo menos un bloque a sección algoritmo antes de intentar guardar un bloque personalizado.";
                alert.setContentText(mensaje);
                alert.show();
            } else {
                StageGuardarAlgoritmo ventanaGuardar = new StageGuardarAlgoritmo();
                ventanaGuardar.showStage();
                String nombreAlgoritmo = ventanaGuardar.getData();
                System.out.println("String guardado " + nombreAlgoritmo);

                Contenido contenidoDelPersonalizado = new Contenido(new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloquePersonalizado.png")));
                Label labelAlgoritmo = new Label(nombreAlgoritmo);
                contenidoDelPersonalizado.agregarNombre(labelAlgoritmo);

                VBox contenedorDelBloqueDisponible = new VBox();

                this.tablero.generarPersonalizado(nombreAlgoritmo);

                VistaBloqueDisponible vistaPersonalizado = new VistaBloqueDisponible(contenidoDelPersonalizado, contenedorDelBloqueDisponible, this.tablero, nombreAlgoritmo, false);
                vistaSeccionBloques.agregarVistaBloque(vistaPersonalizado);
            }
        });
        botonCrearPersonalizado.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonReiniciar = new Button();
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setOnAction(e -> this.reiniciarJuego(stage));
        botonReiniciar.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");
        BotonInstruccionesEventHandler botonInstruccionesEventHandler = new BotonInstruccionesEventHandler();
        botonInstrucciones.setOnAction(botonInstruccionesEventHandler);
        botonInstrucciones.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #0a0401;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");
        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(opcionSalirEventHandler);

        VBox contenedor = new VBox(botonInstrucciones, botonCrearPersonalizado, botonReiniciar, botonSalir);
        contenedor.setSpacing(15);
        contenedor.setPadding(new Insets(25));
        contenedor.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/main/java/com/vista/imagenes/fondoprincipal.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background((imagenDeFondo)));
        contenedor.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 4;" +
                        "-fx-border-color: #000000;");

        this.setLeft(contenedor);
    }

    public void setReproductor(Personaje personaje, Stage stage) {
        VBox contenedor = this.crearVistaPersonaje(personaje);

        Button reproducir = new Button("Reproducir");
        reproducir.setOnAction(e -> {
            tablero.iniciarAlgoritmo();
            vistaPersonaje.getTimeline().play();
            reproducir.setDisable(true);
        });
        reproducir.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        Button reestablecer = new Button("Reestablecer");
        reestablecer.setOnAction(e -> {
            reproducir.setDisable(false);
            vistaPersonaje.getTimeline().stop();
            vistaPersonaje.reiniciarVista();
            this.reiniciarSimulacion(stage);
        });
        reestablecer.setStyle("-fx-border-width: 4;" +
                "-fx-text-fill: #000000;" +
                "-fx-border-color: #e84daf;" +
                "-fx-background-color: #e84daf;" + "-fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;");

        HBox botonera = new HBox(reproducir, reestablecer);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(15);
        botonera.setPadding(new Insets(25));

        contenedor.getChildren().addAll(botonera);
        contenedor.setStyle(
                "-fx-border-style: solid inside;" +
                        "-fx-border-width: 4;" +
                        "-fx-border-color: #000000;");

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
                        "-fx-border-color: #e84daf;");

        VBox contenedor = new VBox(contenedorCanvas);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(20);
        contenedor.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/com/vista/imagenes/fondoprincipal.jpg");
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
        tablero.reestablecerPersonaje(personajeNuevo);
        this.setReproductor(personajeNuevo, stage);
    }

    public void reiniciarJuego(Stage stage) {
        this.tablero = new Tablero();

        this.listas.getChildren().remove(this.bloquesAEjecutar);
        this.bloquesAEjecutar = new VistaBloquesAEjecutar(this.tablero);
        this.listas.getChildren().add(this.bloquesAEjecutar);

        this.setMenu(stage);
        this.setBotonera(stage);
        Personaje personaje = tablero.getPersonaje();
        this.setReproductor(personaje, stage);
        this.setAlgoritmo(stage);
    }
}





