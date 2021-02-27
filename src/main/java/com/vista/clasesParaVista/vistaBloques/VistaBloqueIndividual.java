package com.vista.clasesParaVista.vistaBloques;


import com.vista.clasesParaVista.InterfacesDragAndDrop.Arrastrable;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Receptor;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class VistaBloqueIndividual extends VistaBloque implements Arrastrable, Receptor {

    VistaBloque siguiente = new VistaBloqueNulo();
    VistaBloque anterior = new VistaBloqueNulo();
    ImageView image;

    public VistaBloqueIndividual(ImageView image){
        this.setMaxWidth(75);
        this.setMaxHeight(50);
        this.getChildren().add(image);
        this.image = image;
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

    @Override
    public void asignarSiguiente(VistaBloque siguienteNuevo) {
        this.getChildren().remove(this.siguiente);
        this.getChildren().add(siguienteNuevo);
        this.siguiente = siguienteNuevo;
    }

    @Override
    protected void asignarAnterior(VistaBloque anteriorNuevo){
        this.anterior = anteriorNuevo;
    }

    public void separarDeLaCadena (){
        this.anterior.asignarSiguiente(new VistaBloqueNulo());
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

    @Override
    public VistaBloque copia(){
        return new VistaBloqueIndividual(new ImageView(this.image.getImage()));
    }

    public void setDragConfiguration(){

        image.setOnDragDetected((MouseEvent event)->{
            Dragboard db = this.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            //content.putString("Source text (franz escribio esto)");
            content.putImage(image.getImage());
            db.setContent(content);
            this.separarDeLaCadena();

            System.out.println("DragDetected on VistaBloqueIndividual");
        });

        image.setOnMouseDragged((MouseEvent event)->{
            event.setDragDetect(true);
            System.out.println("MouseDragged on VistaBloqueIndividual");
        });
    }

    public void setDropConfiguration(){

        image.setOnDragOver(new EventHandler<DragEvent>() {
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


        image.setOnDragDropped((DragEvent event)->{
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

        image.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("onDragDone VistaBloqueIndividual");
                if (event.getTransferMode() == TransferMode.MOVE) {
                    System.out.println("TransferMode = MOVE");
                }
                event.consume();
            }
        });
    }
}
