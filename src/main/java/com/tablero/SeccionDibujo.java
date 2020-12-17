package com.tablero;
import com.arista.*;

import java.util.List;

public class SeccionDibujo {

    List<Arista> aristas;

    public void agregarArista(Arista unaArista) {
        aristas.add(unaArista);
    }

    public int cantidadAristas() {
        return aristas.size();
    }
}
