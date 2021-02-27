package com.vista.clasesParaVista.vistaBloques;

import com.vista.Vista;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Arrastrable;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaBloqueSecuencial extends VistaBloque implements Arrastrable, Receptor {

    ImageView imagenBloqueSecuencial;
    VistaBloque siguiente = new VistaBloqueNulo();
    VistaBloque anterior = new VistaBloqueNulo();
    VistaBloque bloqueInicialListaInterna;

    public VistaBloqueSecuencial (ImageView image){
        this.setMaxWidth(75);
        this.setMaxHeight(50);
        this.getChildren().add(image);
        imagenBloqueSecuencial = image;
        ImageView bloqueInicioImagen = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/BloqueInicio.PNG"));
        bloqueInicialListaInterna = new VistaBloqueInicio(bloqueInicioImagen);
        HBox cuerpoMedio = new HBox();
        VBox cuerpoMedioIzquierdo = new VBox();
        cuerpoMedioIzquierdo.setMinWidth(20);
        cuerpoMedioIzquierdo.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        cuerpoMedio.getChildren().addAll(cuerpoMedioIzquierdo, bloqueInicialListaInterna);
        this.getChildren().add(cuerpoMedio);
        this.setDragConfiguration();
        this.setDropConfiguration();
    }

    public void insertarSiguiente(VistaBloque siguienteNuevo){
        this.getChildren().remove(this.siguiente);
        this.getChildren().add(siguienteNuevo);
        siguienteNuevo.asignarAnterior(this);
        siguienteNuevo.ultimoSiguiente().asignarSiguiente(this.siguiente);
        this.siguiente = siguienteNuevo;
    }

    public void asignarSiguiente(VistaBloque siguienteNuevo){

        this.getChildren().remove(this.siguiente);
        this.getChildren().add(siguienteNuevo);
        this.siguiente = siguienteNuevo;
    }

    protected void asignarAnterior(VistaBloque anterior){this.anterior = anterior;}

    public VistaBloque ultimoSiguiente(){
        if (siguiente.esNulo()){
            return this;
        }
        return siguiente.ultimoSiguiente();
    }

    public boolean esNulo(){
        return false;
    }

    public void separarDeLaCadena (){
        this.anterior.asignarSiguiente(new VistaBloqueNulo());
    }

    public VistaBloque copia(){
        return new VistaBloqueSecuencial(new ImageView(this.imagenBloqueSecuencial.getImage()));
    }

    public void setDragConfiguration(){
        imagenBloqueSecuencial.setOnDragDetected((MouseEvent event)->{
            Dragboard db = this.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            //content.putString("Source text (franz escribio esto)");
            content.putImage(imagenBloqueSecuencial.getImage());
            db.setContent(content);
            this.separarDeLaCadena();

            System.out.println("DragDetected on VistaBloqueIndividual");
        });

        imagenBloqueSecuencial.setOnMouseDragged((MouseEvent event)->{
            event.setDragDetect(true);
            System.out.println("MouseDragged on VistaBloqueIndividual");
        });

    }

    public void setDropConfiguration(){

        imagenBloqueSecuencial.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if (dragEvent.getGestureSource().getClass() == VistaBloqueIndividual.class){
                    dragEvent.acceptTransferModes(TransferMode.ANY);
                }
                else if (dragEvent.getGestureSource().getClass() == VistaBloqueDisponible.class){
                    dragEvent.acceptTransferModes(TransferMode.ANY);
                }
                else if (dragEvent.getGestureSource().getClass() == VistaBloqueSecuencial.class){
                    dragEvent.acceptTransferModes(TransferMode.ANY);
                }
                dragEvent.consume();
            }
        });


        imagenBloqueSecuencial.setOnDragDropped((DragEvent event)->{
            System.out.println("DragDropped on VistaBloqueIndividual");
            if (VistaBloqueIndividual.class == event.getGestureSource().getClass() || VistaBloqueSecuencial.class == event.getGestureSource().getClass()) {
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
