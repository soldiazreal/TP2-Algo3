package com.vista.clasesParaVista.vistaBloques;

import com.nodos.Nodo;
import com.nodos.NodoConcreto;
import com.nodos.NodoNulo;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class VistaBloqueInicio extends VistaBloque implements Receptor {

    VistaBloque siguiente = new VistaBloqueNulo();
    ImageView bloqueInicioImagen;
    Nodo nodo;

    public VistaBloqueInicio (ImageView image, Nodo nodoInicial){
        bloqueInicioImagen = image;
        bloqueInicioImagen.setFitHeight(50);
        bloqueInicioImagen.setFitWidth(75);

        nodo = nodoInicial;

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
        nodo.insertarSiguiente(siguienteNuevo.getNodo());
        if (siguienteNuevo.getNodo().getClass() == NodoConcreto.class)
            System.out.println("Se inserta un nodo concreto");
        else if (siguienteNuevo.getNodo().getClass() == NodoNulo.class){
            System.out.println("Se inserta un nodo nulo");
        }
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

    public void setDropConfiguration(){

        bloqueInicioImagen.setOnDragOver(new EventHandler<DragEvent>() {
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

        bloqueInicioImagen.setOnDragDropped((DragEvent event)->{
            System.out.println("DragDropped on VistaBloqueInicio");
            if (VistaBloqueIndividual.class == event.getGestureSource().getClass()) {
                VistaBloque bloque = (VistaBloque) event.getGestureSource();
                this.asignarSiguiente(bloque);

                event.setDropCompleted(true);
            }
            else if (VistaBloqueDisponible.class == event.getGestureSource().getClass()){
                VistaBloqueDisponible vistaBloqueDisponible = (VistaBloqueDisponible) event.getGestureSource();
                VistaBloque copia = vistaBloqueDisponible.copia();
                this.asignarSiguiente(copia);

                event.setDropCompleted(false);
            }
            else {
                event.setDropCompleted(false);
            }
        });
    }
}
