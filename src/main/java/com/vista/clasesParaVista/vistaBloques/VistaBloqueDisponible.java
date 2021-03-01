package com.vista.clasesParaVista.vistaBloques;

import com.nodos.Nodo;
import com.tablero.Tablero;
import com.vista.clasesParaVista.InterfacesDragAndDrop.Arrastrable;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

public class VistaBloqueDisponible extends VBox implements Arrastrable {


    Contenido elContenido;
    VBox contenedor;
    Tablero tablero;
    String nombreBloque;
    boolean tieneListaInternaEditable;

    public VistaBloqueDisponible(Contenido contenido, VBox contenedor, Tablero tablero, String nombre, boolean tieneListaInternaEditable){

        this.tablero = tablero;
        this.contenedor = contenedor;
        this.nombreBloque = nombre;
        //contenido.setFitWidth(75);
       //contenido.setFitHeight(50);
        this.getChildren().add(contenido);
        this.elContenido = contenido;
        this.tieneListaInternaEditable = tieneListaInternaEditable;

        setDragConfiguration();
    }

    public VistaBloque copia(){
        Nodo nodo = tablero.nodoConBloque(nombreBloque);
        ImageView imagenCopia = new ImageView (this.elContenido.getImageView().getImage());
        return new VistaBloqueIndividual((new Contenido(imagenCopia)), nodo, this.tieneListaInternaEditable, nodo.primerNodoListaInternaDeBloque());
    }

    public void setDragConfiguration(){
        elContenido.setOnDragDetected((MouseEvent event)->{//aca hay que hacerlo con contenedor tambien
            System.out.println("DragDetected on BloqueDisponible");
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(elContenido.getImageView().getImage()); //aca hay que hacerlo con contenedor
            db.setContent(content);
        });

        elContenido.setOnMouseDragged((MouseEvent event)->{ //aca hay que hacerlo con contenedor
            event.setDragDetect(true);
            System.out.println("MouseDragged on BloqueDisponible");
        });
    }
}
