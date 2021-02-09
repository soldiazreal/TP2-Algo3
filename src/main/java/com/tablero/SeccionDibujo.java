package com.tablero;
import com.arista.*;
import com.excepciones.AristaANullException;

import java.util.ArrayList;
import java.util.List;

public class SeccionDibujo {

    private final List<Arista> aristas = new ArrayList<>();

    public void agregarArista(Arista unaArista) {
        if (unaArista == null)
            throw new AristaANullException("No se puede agregar una arista a null");
        aristas.add(unaArista);
    }

    public int cantidadAristas() {
        return aristas.size();
    }

    public Arista getArista(int indice){return this.aristas.get(indice);}
}
