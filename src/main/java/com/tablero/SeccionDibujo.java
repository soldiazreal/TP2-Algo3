package com.tablero;
import com.arista.*;

import java.util.ArrayList;
import java.util.List;

public class SeccionDibujo {

    private final List<Arista> aristas = new ArrayList<>();

    public void agregarArista(Arista unaArista) {
        aristas.add(unaArista);
    }

    public int cantidadAristas() {
        return aristas.size();
    }

    public Arista getArista(int indice){return this.aristas.get(indice);}
}
