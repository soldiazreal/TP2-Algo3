package com.factory;
import com.bloques.*;

public class BloqueInvertir implements CrearBloque{
    @Override
    public Inversion generarBloque(){
        return new Inversion();
    }
}
