package com.bloques;

import com.acciones.*;
import com.personaje.*;

public interface Bloque {

    void ejecutarBloque(Personaje unPersonaje);

    void invertirBloque(Personaje unPersonaje);
}
