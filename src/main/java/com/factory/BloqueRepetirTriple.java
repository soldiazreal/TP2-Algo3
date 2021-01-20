package com.factory;
import com.bloques.*;

public class BloqueRepetirTriple implements CrearBloqueSecuencial{
    @Override
    public Repeticion generarSecuencia(Bloque bloque){
        Repeticion bloqueNuevo = new Repeticion(bloque,3);
        return (bloqueNuevo);
    }
}