package com.tablero;
import com.arista.*;

import java.util.ArrayList;
import java.util.List;

public class SeccionDibujo {

    private List<Arista> aristas = new ArrayList<>();
    private int cantidadAristas = 0;

    public void agregarArista(Arista unaArista) {
        aristas.add(unaArista);
    }

    public int cantidadAristas() {
        return aristas.size();
    }
}
