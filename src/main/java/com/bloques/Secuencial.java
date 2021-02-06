package com.bloques;
import java.util.ArrayList;
import java.util.List;
import com.personaje.Personaje;

public abstract class Secuencial implements Bloque{
    protected final List<Bloque> bloques = new ArrayList<>();

    public void agregarBloque(Bloque unBloque){
        bloques.add(unBloque);
    }

    public int cantidadBloques(){
        return bloques.size();
    }

    //No se si esto se hace asi como que es doble abstraccion dado que la ejecucion de los bloques
    //secuenciales tambien es diferente
    @Override
    public abstract void ejecutarBloque(Personaje unPersonaje);

    @Override
    public abstract void invertirBloque(Personaje unPersonaje);
}
