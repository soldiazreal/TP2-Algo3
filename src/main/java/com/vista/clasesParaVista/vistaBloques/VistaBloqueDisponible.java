package com.vista.clasesParaVista.vistaBloques;

import com.vista.Vista;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Arrastrable;
import com.vista.clasesParaVista.vistaBloques.VistaBloque;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueIndividual;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueInicio;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueNulo;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaBloqueDisponible extends VistaBloque implements Arrastrable {


    ImageView imageView;
    VistaBloque bloque;
    VBox contenedor;

    public VistaBloqueDisponible(ImageView image, VistaBloque bloque, VBox contenedor){

        this.contenedor = contenedor;
        this.bloque = bloque;
        image.setFitWidth(75);
        image.setFitHeight(50);
        this.getChildren().add(image);
        imageView = image;

        setDragConfiguration();
    }

    public void asignarSiguiente(VistaBloque siguiente){}

    protected void asignarAnterior(VistaBloque anterior){}

    public VistaBloque ultimoSiguiente(){
        return null;
    }

    public boolean esNulo(){
        return false;
    }

    public VistaBloque copia(){

        System.out.println("copia vistaBloqueDisponible");

        contenedor.getChildren().remove(this);
        contenedor.getChildren().add(new VistaBloqueDisponible(imageView, bloque, contenedor));

        return bloque.copia();
    }

    public void setDragConfiguration(){
        imageView.setOnDragDetected((MouseEvent event)->{
            System.out.println("DragDetected on BloqueDisponible");
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(imageView.getImage());
            db.setContent(content);
        });

        imageView.setOnMouseDragged((MouseEvent event)->{
            event.setDragDetect(true);
            System.out.println("MouseDragged on BloqueDisponible");
        });

        imageView.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("onDragDone VistaBloqueDisponible");
                if (event.getTransferMode() == TransferMode.MOVE) {
                    System.out.println("TransferMode = MOVE");
                }
                event.consume();
            }
        });
    }
}
