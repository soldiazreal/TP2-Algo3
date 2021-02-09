package com.excepciones;

public class BloqueInexistenteException extends RuntimeException {
    public BloqueInexistenteException (String mensaje) {
        super(mensaje);
    }
}
