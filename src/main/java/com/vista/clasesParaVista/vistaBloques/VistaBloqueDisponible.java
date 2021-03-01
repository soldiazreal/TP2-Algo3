package com.vista.clasesParaVista.vistaBloques;

import com.nodos.Nodo;
import com.tablero.Tablero;
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

public class VistaBloqueDisponible extends VBox implements Arrastrable {


    ImageView imageView;
    VBox contenedor;
    Tablero tablero;
    String nombreBloque;
    boolean tieneListaInternaEditable;

    public VistaBloqueDisponible(ImageView image, VBox contenedor, Tablero tablero, String nombre, boolean tieneListaInternaEditable){

        this.tablero = tablero;
        this.contenedor = contenedor;
        this.nombreBloque = nombre;
        image.setFitWidth(75);
        image.setFitHeight(50);
        this.getChildren().add(image);
        imageView = image;
        this.tieneListaInternaEditable = tieneListaInternaEditable;

        setDragConfiguration();
    }

    public VistaBloque copia(){
        Nodo nodo = tablero.nodoConBloque(nombreBloque);
        return new VistaBloqueIndividual(new ImageView(this.imageView.getImage()), nodo, this.tieneListaInternaEditable, nodo.primerNodoListaInternaDeBloque());
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
    }
}
