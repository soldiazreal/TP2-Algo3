package com.vista.clasesParaVista.vistaSeccionBloques;

import com.tablero.Tablero;
import com.vista.clasesParaVista.vistaBloques.Contenido;
import com.vista.clasesParaVista.vistaBloques.VistaBloqueDisponible;
import com.vista.clasesParaVista.vistaBloques.VistaBloque;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VistaSeccionBloques extends VBox{

    Tablero tablero;

    public VistaSeccionBloques(Tablero tablero){
        //configurar estilo

        this.tablero = tablero;
        //agrega los bloques predeterminados a su lista
        this.agregarBloquesPredeterminados();
    }


    public void agregarVistaBloque(VistaBloqueDisponible vistaBloque){
        this.getChildren().add(vistaBloque);
    }

    private void agregarBloquesPredeterminados(){

        //creo las imagenes para los bloques
        ImageView imagenBloqueMoverDerecha = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueMoverDerecha.jpeg"));
        ImageView imagenMoverIzquierda = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueMoverIzquierda.jpeg"));
        ImageView imagenMoverArriba = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueMoverArriba.jpeg"));
        ImageView imagenMoverAbajo = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueMoverAbajo.jpeg"));
        ImageView imagenBajarLapiz = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueBajarLapiz.jpg"));
        ImageView imagenLevantarLapiz = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueLevantarLapiz.jpg"));
        ImageView imagenRepetir2 = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueRepetir2.jpeg"));
        ImageView imagenRepetir3 = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueRepetir3.jpeg"));
        ImageView imagenInvertir = new ImageView(new Image("file:src/main/java/com/vista/imagenes/bloqueImagenes/bloqueInvertir.png"));

        //creo contenedores para los bloques de seccion bloque
        VBox contenedorBloqueMoverDerecha = new VBox();
        VBox contenedorBloqueMoverIzquierda = new VBox();
        VBox contenedorBloqueMoverArriba = new VBox();
        VBox contenedorBloqueMoverAbajo = new VBox();
        VBox contenedorBloqueLevantarLapiz = new VBox();
        VBox contenedorBloqueBajarLapiz = new VBox();
        VBox contenedorBloqueRepetir2 = new VBox();
        VBox contenedorBloqueRepetir3 = new VBox();
        VBox contenedorBloqueInvertir = new VBox();


        //creo los bloques de seccion bloque y los agrego a sus respectivos contenedores
        contenedorBloqueMoverDerecha.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenBloqueMoverDerecha), contenedorBloqueMoverDerecha, tablero, "MoverDerecha", false));
        contenedorBloqueMoverIzquierda.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenMoverIzquierda), contenedorBloqueMoverIzquierda, tablero, "MoverIzquierda", false));
        contenedorBloqueMoverArriba.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenMoverArriba), contenedorBloqueMoverArriba, tablero, "MoverArriba", false));
        contenedorBloqueMoverAbajo.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenMoverAbajo), contenedorBloqueMoverAbajo, tablero, "MoverAbajo", false));
        contenedorBloqueLevantarLapiz.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenLevantarLapiz), contenedorBloqueLevantarLapiz, tablero, "LevantarLapiz", false));
        contenedorBloqueBajarLapiz.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenBajarLapiz), contenedorBloqueBajarLapiz, tablero, "BajarLapiz", false));
        contenedorBloqueRepetir2.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenRepetir2), contenedorBloqueRepetir2, tablero, "RepetirDoble", true));
        contenedorBloqueRepetir3.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenRepetir3), contenedorBloqueRepetir3, tablero, "RepetirTriple", true));
        contenedorBloqueInvertir.getChildren().add(new VistaBloqueDisponible(new Contenido(imagenInvertir), contenedorBloqueInvertir, tablero, "Invertir", true));

        //agrego de manera ordenada los contenedores de bloques de seccion bloque
        this.getChildren().add(contenedorBloqueMoverDerecha);
        this.getChildren().add(contenedorBloqueMoverIzquierda);
        this.getChildren().add(contenedorBloqueMoverArriba);
        this.getChildren().add(contenedorBloqueMoverAbajo);
        this.getChildren().add(contenedorBloqueLevantarLapiz);
        this.getChildren().add(contenedorBloqueBajarLapiz);
        this.getChildren().add(contenedorBloqueRepetir2);
        this.getChildren().add(contenedorBloqueRepetir3);
        this.getChildren().add(contenedorBloqueInvertir);
    }

}
