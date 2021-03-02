package com.bloques;

import com.nodos.Nodo;
import com.personaje.*;

public interface Bloque {

    void ejecutarBloque(Personaje unPersonaje);

    void invertirBloque(Personaje unPersonaje);

    Bloque copia ();

    Nodo primerNodoListaInterna();
}
