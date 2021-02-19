package com.vista.clasesParaVista;

import com.personaje.Personaje;
import com.tablero.SeccionDibujo;
import com.tablero.Tablero;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import java.util.EventListener;

public class VistaPersonaje implements InvalidationListener {

    private Personaje personaje;
    Canvas canvas;

    public VistaPersonaje (Personaje personaje, Canvas canvas) {
        this.personaje = personaje;
        this.canvas = canvas;
    }

    public void dibujar () {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        System.out.println("POSICION QUE RECIBE CANVAS  posicionx:" +personaje.getPosicionActual().getX() + "posiciony:" + personaje.getPosicionActual().getY());
        //EL "-" es para que no se invierta el canvas en el eje y, no sé por qué pasa pero poner el - lo soluciona sin generar problemas al modelo, las posiciones son las mismas
        //la multiplicacion es para que se mueva a mayor distancia por accion
        canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/personaje2.jpg"), (personaje.getPosicionActual().getX())*40+230, -(personaje.getPosicionActual().getY())*40+210, 35, 50);
    }

    private void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 500, 500);
    }

    @Override
    public void invalidated(Observable observable) {
        System.out.println("le llego la notificacion");
        this.dibujar();
    }
}
