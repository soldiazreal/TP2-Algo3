package com.posicion;

public class Posicion {

    public int x;
    public int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void modificarCoordenadas(int variacionX, int variacionY) {
        x = x + variacionX;
        y = y + variacionY;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
