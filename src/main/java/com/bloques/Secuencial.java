package com.bloques;
import java.util.ArrayList;
import java.util.List;
import com.personaje.Personaje;
import com.nodos.*;

public abstract class Secuencial implements Bloque{
    protected final Nodo bloques = new NodoConcreto(new Inicial());
    int cantidad = 0;

    public void agregarBloque(Nodo siguiente){
        bloques.ultimoSiguiente().insertarSiguiente(siguiente);
        this.cantidad += 1;
    }

    public int cantidadBloques(){
        return this.cantidad;
    }

    //No se si esto se hace asi como que es doble abstraccion dado que la ejecucion de los bloques
    //secuenciales tambien es diferente
    @Override
    public abstract void ejecutarBloque(Personaje unPersonaje);

    @Override
    public abstract void invertirBloque(Personaje unPersonaje);
}
