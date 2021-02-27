package com.vista.clasesParaVista.vistaBloques;

import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class VistaBloqueInicio extends VistaBloque implements Receptor {

    VistaBloque siguiente = new VistaBloqueNulo();
    ImageView bloqueInicioImagen;

    public VistaBloqueInicio (ImageView image){
        bloqueInicioImagen = image;
        bloqueInicioImagen.setFitHeight(50);
        bloqueInicioImagen.setFitWidth(75);

        this.setMaxHeight(50);
        this.setMaxWidth(75);
        this.getChildren().add(bloqueInicioImagen);

        this.setDropConfiguration();
    }

    public void asignarSiguiente(VistaBloque siguienteNuevo){
        this.getChildren().remove(this.siguiente);
        siguienteNuevo.ultimoSiguiente().asignarSiguiente(this.siguiente);
        siguienteNuevo.asignarAnterior(this);
        this.getChildren().add(siguienteNuevo);
        this.siguiente = siguienteNuevo;
    }

    protected void asignarAnterior(VistaBloque anterior){
    }

    public VistaBloque ultimoSiguiente(){
        if (siguiente.esNulo())
            return this;
        return siguiente.ultimoSiguiente();
    }

    public boolean esNulo(){
        return false;
    }

    @Override
    public VistaBloque copia(){
        return new VistaBloqueInicio(bloqueInicioImagen);
    }

    public void setDropConfiguration(){

        bloqueInicioImagen.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if (dragEvent.getGestureSource().getClass() == VistaBloqueIndividual.class){
                    dragEvent.acceptTransferModes(TransferMode.ANY);
                }
                else if (dragEvent.getGestureSource().getClass() == VistaBloqueDisponible.class){
                    dragEvent.acceptTransferModes(TransferMode.ANY);
                }
                dragEvent.consume();
            }
        });

        bloqueInicioImagen.setOnDragDropped((DragEvent event)->{
            System.out.println("DragDropped on VistaBloqueInicio");
            if (VistaBloqueIndividual.class == event.getGestureSource().getClass()) {
                VistaBloque bloque = (VistaBloque) event.getGestureSource();
                this.asignarSiguiente(bloque);
                event.setDropCompleted(true);
            }
            else if (VistaBloqueDisponible.class == event.getGestureSource().getClass()){
                VistaBloqueDisponible vistaBloqueDisponible = (VistaBloqueDisponible) event.getGestureSource();
                this.asignarSiguiente(vistaBloqueDisponible.copia());
                event.setDropCompleted(false);
            }
            else {
                event.setDropCompleted(false);
            }
        });

        bloqueInicioImagen.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("onDragDone VistaBloqueInicio");
                if (event.getTransferMode() == TransferMode.MOVE) {
                    System.out.println("TransferMode = MOVE");
                }
                event.consume();
            }
        });
    }
}
