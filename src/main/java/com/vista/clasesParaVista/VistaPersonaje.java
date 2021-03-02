package com.vista.clasesParaVista;

import com.arista.Arista;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class VistaPersonaje implements InvalidationListener {

    private final Timeline timeline;

    private final Personaje personaje;
    private final Canvas canvas;
    private final SeccionDibujo seccionDibujo;
    private Posicion posicionAnterior = new Posicion(0, 0);
    private List<Posicion> recorridoPersonaje = new ArrayList<>();
    private List<Arista> aristasMostradas = new ArrayList<>();
    private int contadorRecorrido = 0;
    private int contadorDibujo = 0;

    public VistaPersonaje (Personaje personaje, Canvas canvas) {
        this.personaje = personaje;
        this.seccionDibujo = personaje.getSeccionDibujo();
        this.canvas = canvas;

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> this.simularUnPaso()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public boolean posicionPersonajeIgualAArista(Posicion personaje, Posicion posicionArista) {
        return personaje.getX() == posicionArista.getX() && personaje.getY() == posicionArista.getY();
    }

    public void simularUnPaso() {
        if (contadorRecorrido < recorridoPersonaje.size()) {
            this.clean();
            this.mostrarAristas(contadorDibujo);
            if (this.posicionInvalida()) {
                this.clean();
                canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongMuerto.png"),  221, 209, 47, 47);
                pararYAlertar();
            } else {
                dibujarPersonaje(contadorRecorrido);
            }

            if ( !this.posicionInvalida() && contadorDibujo < seccionDibujo.cantidadAristas() && posicionPersonajeIgualAArista(recorridoPersonaje.get(contadorRecorrido), seccionDibujo.getArista(contadorDibujo).getPosicionFinal())) {
                canvas.getGraphicsContext2D().setFill(Color.BLACK);
                canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(contadorDibujo).getPosicionInicial().getX()) * 40 + 246, -(seccionDibujo.getArista(contadorDibujo).getPosicionInicial().getY()) * 40 + 246, 7, 7);
                canvas.getGraphicsContext2D().setFill(Color.BLACK);
                canvas.getGraphicsContext2D().fillOval((seccionDibujo.getArista(contadorDibujo).getPosicionFinal().getX()) * 40 + 246, -(seccionDibujo.getArista(contadorDibujo).getPosicionFinal().getY()) * 40 + 246, 7, 7);
                canvas.getGraphicsContext2D().beginPath();
                canvas.getGraphicsContext2D().moveTo((seccionDibujo.getArista(contadorDibujo).getPosicionInicial().getX()) * 40 + 250, -(seccionDibujo.getArista(contadorDibujo).getPosicionInicial().getY()) * 40 + 250);
                canvas.getGraphicsContext2D().lineTo((seccionDibujo.getArista(contadorDibujo).getPosicionFinal().getX()) * 40 + 250, -(seccionDibujo.getArista(contadorDibujo).getPosicionFinal().getY()) * 40 + 250);
                canvas.getGraphicsContext2D().closePath();
                canvas.getGraphicsContext2D().stroke();

                aristasMostradas.add(seccionDibujo.getArista(contadorDibujo));
                contadorDibujo++;
            }
            posicionAnterior = recorridoPersonaje.get(contadorRecorrido);
            contadorRecorrido++;
        }
    }

    public void dibujarPersonaje(int contadorRecorrido) {
        if (recorridoPersonaje.get(contadorRecorrido).getY() > posicionAnterior.getY()) {
            canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongEspalda.jpg"), (recorridoPersonaje.get(contadorRecorrido).getX()) * 40 + 210, -(recorridoPersonaje.get(contadorRecorrido).getY()) * 40 + 211, 30, 37);
        }else if (recorridoPersonaje.get(contadorRecorrido).getY() < posicionAnterior.getY()) {
            canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongQuieto.jpg"), (recorridoPersonaje.get(contadorRecorrido).getX()) * 40 + 210, -(recorridoPersonaje.get(contadorRecorrido).getY()) * 40 + 211, 31, 37);
        }else if (recorridoPersonaje.get(contadorRecorrido).getX() >= posicionAnterior.getX()){
            canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongMoviendose.png"), (recorridoPersonaje.get(contadorRecorrido).getX()) * 40 + 221, -(recorridoPersonaje.get(contadorRecorrido).getY()) * 40 + 209, 40, 37);
        }else {
            canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongMovIzq.png"), (recorridoPersonaje.get(contadorRecorrido).getX()) * 40 + 221, -(recorridoPersonaje.get(contadorRecorrido).getY()) * 40 + 209, 40, 37);
        }
    }

    public Boolean posicionInvalida() {
        Boolean contactoX = Math.abs(recorridoPersonaje.get(contadorRecorrido).getX()*40+250) >= 500;
        Boolean contactoX2 = Math.abs(-recorridoPersonaje.get(contadorRecorrido).getX()*40+250) >= 500;
        Boolean contactoY = Math.abs(recorridoPersonaje.get(contadorRecorrido).getY()*40+250) >= 500;
        Boolean contactoY2 = Math.abs(-recorridoPersonaje.get(contadorRecorrido).getY()*40+250) >= 500;

        return contactoX || contactoY || contactoX2 || contactoY2;
    }

    public void pararYAlertar() {
        timeline.stop();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Algoritmo no se puede representar!");
        String mensaje = "Lo sentimos, el algoritmo que creaste se excede del límite representable. Por favor clickeá en reestablecer e intentalo de nuevo.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void mostrarAristas(int limite) {
        for (int i = 0; i < limite; i++) {
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((aristasMostradas.get(i).getPosicionInicial().getX()) * 40 + 246, -(aristasMostradas.get(i).getPosicionInicial().getY()) * 40 + 246, 7, 7);
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillOval((aristasMostradas.get(i).getPosicionFinal().getX()) * 40 + 246, -(aristasMostradas.get(i).getPosicionFinal().getY()) * 40 + 246, 7, 7);

            canvas.getGraphicsContext2D().beginPath();
            canvas.getGraphicsContext2D().moveTo((aristasMostradas.get(i).getPosicionInicial().getX()) * 40 + 250, -(aristasMostradas.get(i).getPosicionInicial().getY()) * 40 + 250);
            canvas.getGraphicsContext2D().lineTo((aristasMostradas.get(i).getPosicionFinal().getX()) * 40 + 250, -(aristasMostradas.get(i).getPosicionFinal().getY()) * 40 + 250);
            canvas.getGraphicsContext2D().closePath();
            canvas.getGraphicsContext2D().stroke();
        }
    }

    private void clean() {
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 500, 500);
    }

    public void iniciarVista(){
        this.clean();
        canvas.getGraphicsContext2D().drawImage(new Image("file:src/main/java/com/vista/imagenes/amongQuieto.jpg"),  221, 209, 35, 43);
    }

    public void reiniciarVista() {
        recorridoPersonaje = new ArrayList<>();
        aristasMostradas = new ArrayList<>();
        contadorRecorrido = 0;
        contadorDibujo = 0;
    }

    @Override
    public void invalidated(Observable observable) {
        recorridoPersonaje.add(new Posicion(personaje.getPosicionActual().getX(), personaje.getPosicionActual().getY()));
    }

    public Timeline getTimeline() {
        return timeline;
    }
}