package com.vista.clasesParaVista.vistaBloques;


import com.nodos.Nodo;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Arrastrable;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaBloqueIndividual extends VistaBloque implements Arrastrable, Receptor {

    VistaBloque siguiente = new VistaBloqueNulo();
    VistaBloque anterior = new VistaBloqueNulo();
    Contenido elContenido;

    public VistaBloqueIndividual(Contenido contenido, Nodo nodo, boolean esSecuencial, Nodo primerNodoListaInterna){
        this.setMaxWidth(75);
        this.setMaxHeight(50);
        this.getChildren().add(contenido);
        this.elContenido = contenido;
        this.nodo = nodo;
        this.setDragConfiguration();
        this.setDropConfiguration();

        if (esSecuencial){
            ImageView bloqueInicioImagen = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/BloqueInicio.PNG"));
            VistaBloque bloqueInicialListaInterna = new VistaBloqueInicio(new Contenido(bloqueInicioImagen), primerNodoListaInterna);
            HBox cuerpoMedio = new HBox();
            VBox cuerpoMedioIzquierdo = new VBox();
            cuerpoMedioIzquierdo.setMinWidth(20);
            cuerpoMedioIzquierdo.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, CornerRadii.EMPTY, Insets.EMPTY)));
            cuerpoMedio.getChildren().addAll(cuerpoMedioIzquierdo, bloqueInicialListaInterna);
            this.getChildren().add(cuerpoMedio);
        }
    }

    public void insertarSiguiente(VistaBloque siguienteNuevo){
        this.getChildren().remove(this.siguiente);
        this.getChildren().add(siguienteNuevo);
        siguienteNuevo.asignarAnterior(this);
        siguienteNuevo.ultimoSiguiente().asignarSiguiente(this.siguiente);
        this.siguiente = siguienteNuevo;

        this.nodo.insertarSiguiente(siguienteNuevo.getNodo());
    }

    @Override
    public void asignarSiguiente(VistaBloque siguienteNuevo) {
        this.getChildren().remove(this.siguiente);
        this.getChildren().add(siguienteNuevo);
        this.siguiente = siguienteNuevo;
        siguienteNuevo.asignarAnterior(this);
    }

    @Override
    public void asignarASiguienteUnNulo(){
        VistaBloque nulo = new VistaBloqueNulo();
        this.getChildren().remove(this.siguiente);
        this.getChildren().add(nulo);
        this.siguiente = nulo;
        this.nodo.asignarSiguiente(nulo.getNodo());
    }

    @Override
    protected void asignarAnterior(VistaBloque anteriorNuevo){
        this.anterior = anteriorNuevo;
    }

    public void separarDeLaCadena (){
        this.anterior.asignarASiguienteUnNulo();
        this.anterior = new VistaBloqueNulo();
    }

    @Override
    public boolean esNulo(){
        return false;
    }

    @Override
    public VistaBloque ultimoSiguiente(){
        if (siguiente.esNulo()){
            return this;
        }
        return siguiente.ultimoSiguiente();
    }

    public void setDragConfiguration(){

        elContenido.setOnDragDetected((MouseEvent event)->{
            Dragboard db = this.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(elContenido.getImageView().getImage());
            db.setContent(content);
            this.separarDeLaCadena();

            System.out.println("DragDetected on VistaBloqueIndividual");
        });

        elContenido.setOnMouseDragged((MouseEvent event)->{
            event.setDragDetect(true);
            System.out.println("MouseDragged on VistaBloqueIndividual");
        });
    }

    public void setDropConfiguration(){

        elContenido.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if (dragEvent.getGestureSource().getClass() == VistaBloqueIndividual.class){
                    dragEvent.acceptTransferModes(TransferMode.MOVE);
                }
                else if (dragEvent.getGestureSource().getClass() == VistaBloqueDisponible.class){
                    dragEvent.acceptTransferModes(TransferMode.COPY);
                }
                dragEvent.consume();
            }
        });


        elContenido.setOnDragDropped((DragEvent event)->{
            System.out.println("DragDropped on VistaBloqueIndividual");
            if (VistaBloqueIndividual.class == event.getGestureSource().getClass()) {
                VistaBloque bloque = (VistaBloque) event.getGestureSource();
                this.insertarSiguiente(bloque);
                event.setDropCompleted(true);
            }
            else if (event.getGestureSource().getClass() == VistaBloqueDisponible.class){
                VistaBloqueDisponible vistaBloqueDisponible = (VistaBloqueDisponible) event.getGestureSource();
                this.insertarSiguiente(vistaBloqueDisponible.copia());
                event.setDropCompleted(true);
            }
            else {
                event.setDropCompleted(false);
            }
        });
    }
}
