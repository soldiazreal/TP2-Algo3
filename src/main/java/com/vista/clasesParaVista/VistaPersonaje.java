package com.vista.clasesParaVista;

import com.arista.Arista;
import com.personaje.Personaje;
import com.posicion.Posicion;
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
        this.mostrarAristas(personaje.getSeccionDibujo());
        /*canvas.getGraphicsContext2D().beginPath();
        canvas.getGraphicsContext2D().moveTo(250, 250);
        canvas.getGraphicsContext2D().lineTo(400, 400);
        canvas.getGraphicsContext2D().closePath();
        canvas.getGraphicsContext2D().stroke();
*/
        canvas.getGraphicsContext2D().setFill(Color.RED);
        System.out.println("POSICION QUE RECIBE CANVAS  posicionx:" +personaje.getPosicionActual().getX() + "posiciony:" + personaje.getPosicionActual().getY());
        //EL "-" es para que no se invierta el canvas en el eje y, no sé por qué pasa pero poner el - lo soluciona sin generar problemas al modelo, las posiciones son las mismas
        //la multiplicacion es para que se mueva a mayor distancia por accion
        canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/personaje2.jpg"), (personaje.getPosicionActual().getX())*40+230, -(personaje.getPosicionActual().getY())*40+205, 25, 40);
    }

    public void mostrarAristas(SeccionDibujo seccionDibujo) {
        seccionDibujo.agregarArista(new Arista(new Posicion(0,0), new Posicion(1, 0)));
        seccionDibujo.agregarArista(new Arista(new Posicion(1,0), new Posicion(2, 0)));
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(0).getPosicionInicial().getX())*40+246, -(seccionDibujo.getArista(0).getPosicionInicial().getY())*40+246 , 7 , 7);
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(0).getPosicionFinal().getX())*40+246, -(seccionDibujo.getArista(0).getPosicionFinal().getY())*40+246, 7 , 7);

            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo((seccionDibujo.getArista(0).getPosicionInicial().getX())*40+250, -(seccionDibujo.getArista(0).getPosicionInicial().getY())*40+250);
            canvas.getGraphicsContext2D().lineTo((seccionDibujo.getArista(0).getPosicionFinal().getX())*40+250, -(seccionDibujo.getArista(0).getPosicionFinal().getY())*40+250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();
/*
        //  ESTO ANDAAAA
        if (personaje.getPosicionActual().getX() != 0) {
            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo(250, 250);
            canvas.getGraphicsContext2D().lineTo( 300, 250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();

            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo(310, 250);
            canvas.getGraphicsContext2D().lineTo( 360, 250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();
        }
        if (personaje.getPosicionActual().getX() ==0) {
            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo(250, 250);
            canvas.getGraphicsContext2D().lineTo(300, 250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();
        }
*/

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
