package com.bloques;

import com.personaje.Personaje;

public class Inicial implements Bloque{
    @Override
    public void ejecutarBloque(Personaje unPersonaje){

    }

    @Override
    public void invertirBloque(Personaje unPersonaje){
    }

    @Override
    public Bloque copia(){
        return this;
    }
}
