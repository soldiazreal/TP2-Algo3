package com.posicion;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void modificarCoordenadas(int variacionX, int variacionY) {
        x = x + variacionX;
        y = y + variacionY;
    }

    public Posicion copiaDePosicion (){
        return new Posicion(x, y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
