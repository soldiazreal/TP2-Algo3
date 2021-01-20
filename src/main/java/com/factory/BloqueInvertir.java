package com.factory;
import com.bloques.*;

public class BloqueInvertir implements CrearBloqueSecuencial{
    @Override
    public Inversion generarSecuencia(Bloque bloque){
        Inversion bloqueNuevo = new Inversion(bloque);
        return (bloqueNuevo);
    }
}
