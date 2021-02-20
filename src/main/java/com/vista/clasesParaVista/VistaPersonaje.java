package com.vista.clasesParaVista;

import com.personaje.Personaje;
import com.tablero.SeccionDibujo;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaPersonaje implements InvalidationListener {

    private Personaje personaje;
    Canvas canvas;
    Boolean seguirReproduciendo = true;

    public VistaPersonaje (Personaje personaje, Canvas canvas) {
        this.personaje = personaje;
        this.canvas = canvas;
    }

    public void dibujar () {
        if (seguirReproduciendo) {
            this.clean();
            this.mostrarAristas(personaje.getSeccionDibujo());

            canvas.getGraphicsContext2D().setFill(Color.RED);
            System.out.println("POSICION QUE RECIBE CANVAS  posicionx:" + personaje.getPosicionActual().getX() + "posiciony:" + personaje.getPosicionActual().getY());
            //EL "-" es para que no se invierta el canvas en el eje y, no sé por qué pasa pero poner el - lo soluciona sin generar problemas al modelo, las posiciones son las mismas
            //la multiplicacion es para que se mueva a mayor distancia por accion
            canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/personaje2.jpg"), (personaje.getPosicionActual().getX()) * 40 + 221, -(personaje.getPosicionActual().getY()) * 40 + 209, 25, 40);

            this.validarPosicion();
        }
    }

    public void validarPosicion () {
        Boolean contactoX = Math.abs(personaje.getPosicionActual().getX()*40+250) >= 500;
        Boolean contactoX2 = Math.abs(-personaje.getPosicionActual().getX()*40+250) >= 500;
        Boolean contactoY = Math.abs(personaje.getPosicionActual().getY()*40+250) >= 500;
        Boolean contactoY2 = Math.abs(-personaje.getPosicionActual().getY()*40+250) >= 500;

        if (contactoX || contactoY || contactoX2 || contactoY2) {
            seguirReproduciendo = false;

            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().rect(3,3,494,494);
            canvas.getGraphicsContext2D().setFill(Color.RED);
            canvas.getGraphicsContext2D().fill();
            canvas.getGraphicsContext2D().stroke();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Algoritmo no se puede representar!");
            String mensaje = "Lo sentimos, el algoritmo que creaste se excede del límite representable. Por favor clickeá en reestablecer e intentalo de nuevo.";
            alert.setContentText(mensaje);
            alert.show();
        }
    }

    public void mostrarAristas(SeccionDibujo seccionDibujo) {
        System.out.println("cantidad aristas" + seccionDibujo.cantidadAristas());
        for (int i = 0; i < seccionDibujo.cantidadAristas(); i++) {
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(i).getPosicionInicial().getX()) * 40 + 246, -(seccionDibujo.getArista(i).getPosicionInicial().getY()) * 40 + 246, 7, 7);
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(i).getPosicionFinal().getX()) * 40 + 246, -(seccionDibujo.getArista(i).getPosicionFinal().getY()) * 40 + 246, 7, 7);

            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo((seccionDibujo.getArista(i).getPosicionInicial().getX()) * 40 + 250, -(seccionDibujo.getArista(i).getPosicionInicial().getY()) * 40 + 250);
            canvas.getGraphicsContext2D().lineTo((seccionDibujo.getArista(i).getPosicionFinal().getX()) * 40 + 250, -(seccionDibujo.getArista(i).getPosicionFinal().getY()) * 40 + 250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();
        }
    }

    private void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 500, 500);
    }

    @Override
    public void invalidated(Observable observable) {
        System.out.println("le llego la notificacion");
        this.dibujar();
    }
}
