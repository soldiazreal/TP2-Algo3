package com.factory;
import com.bloques.*;

public class BloqueRepetirTriple implements CrearBloque{
    @Override
    public Repeticion generarBloque(){
        return new Repeticion(3);
    }
}