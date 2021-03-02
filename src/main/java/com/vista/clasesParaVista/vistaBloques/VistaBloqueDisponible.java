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
        this.getChildren().add(contenido);
        this.elContenido = contenido;
        this.tieneListaInternaEditable = tieneListaInternaEditable;

        setDragConfiguration();
    }

    public VistaBloque copia(){
        Nodo nodo = tablero.nodoConBloque(nombreBloque);
        return new VistaBloqueIndividual(this.elContenido.copiaContenido(), nodo, this.tieneListaInternaEditable, nodo.primerNodoListaInternaDeBloque());
    }

    public void setDragConfiguration(){
        elContenido.setOnDragDetected((MouseEvent event)->{
            System.out.println("DragDetected on BloqueDisponible");
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(elContenido.getImageView().getImage());
            db.setContent(content);
        });

        elContenido.setOnMouseDragged((MouseEvent event)->{
            event.setDragDetect(true);
            System.out.println("MouseDragged on BloqueDisponible");
        });
    }
}
