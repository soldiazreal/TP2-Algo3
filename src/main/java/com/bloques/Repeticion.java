package com.bloques;

import com.excepciones.ValorInvalidoException;
import com.personaje.Personaje;

public class Repeticion extends Secuencial{
    private int repeticiones;

    public Repeticion(int repeticiones) {
        if (repeticiones <= 0){
            throw new ValorInvalidoException("No se puede crear el bloque con repeticiones negativo");
        }
        this.repeticiones = repeticiones;
    }

    @Override
    public void invertirBloque(Personaje unPersonaje) {
        for(int i = 0; i < repeticiones; ++i){
            for (Bloque elBloque : this.bloques) {
                elBloque.invertirBloque(unPersonaje);
            }
        }
    }

    @Override
    public void ejecutarBloque(Personaje unPersonaje) {
        for(int i = 0; i < repeticiones; ++i){
            for (Bloque elBloque : this.bloques) {
             elBloque.ejecutarBloque(unPersonaje);
            }
        }
    }
}
