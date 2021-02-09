package com.lapiz;

import com.excepciones.SeccionDibujoNullException;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;

public class LapizLevantado extends Lapiz{

    @Override
    public void usar(Posicion inicio, Posicion actual, SeccionDibujo seccionDibujo){
        if (seccionDibujo == null)
            throw new SeccionDibujoNullException("No se puede usar Lapiz con seccionDibujo a null");
    }
}