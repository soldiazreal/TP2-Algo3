package com.factory;
import com.bloques.*;

public class BloqueRepetirDoble implements CrearBloqueSecuencial{
    @Override
    public Repeticion generarSecuencia(Bloque bloque){
        Repeticion bloqueNuevo = new Repeticion(bloque,2);
        return (bloqueNuevo);
    }
}