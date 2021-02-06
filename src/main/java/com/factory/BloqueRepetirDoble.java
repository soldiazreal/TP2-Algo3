package com.factory;
import com.bloques.*;

public class BloqueRepetirDoble implements CrearBloque{
    @Override
    public Repeticion generarBloque(){
        return new Repeticion(2);
    }
}