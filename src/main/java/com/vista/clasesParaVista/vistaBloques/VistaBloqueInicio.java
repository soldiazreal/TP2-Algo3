package com.vista.clasesParaVista.vistaBloques;

import com.nodos.Nodo;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class VistaBloqueInicio extends VistaBloque implements Receptor {

    VistaBloque siguiente = new VistaBloqueNulo();
    Contenido bloqueInicioImagen;

    public VistaBloqueInicio (Contenido contenido, Nodo nodoInicial){
        bloqueInicioImagen = contenido;

        nodo = nodoInicial;

        this.setMaxHeight(50);
        this.setMaxWidth(75);
        this.getChildren().add(bloqueInicioImagen);

        this.setDropConfiguration();
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
                this.insertarSiguiente(bloque);

                event.setDropCompleted(true);
            }
            else if (VistaBloqueDisponible.class == event.getGestureSource().getClass()){
                VistaBloqueDisponible vistaBloqueDisponible = (VistaBloqueDisponible) event.getGestureSource();
                VistaBloque copia = vistaBloqueDisponible.copia();
                this.insertarSiguiente(copia);

                event.setDropCompleted(false);
            }
            else {
                event.setDropCompleted(false);
            }
        });
    }
}
