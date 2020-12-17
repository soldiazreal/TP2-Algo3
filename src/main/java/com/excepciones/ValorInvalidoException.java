package com.excepciones;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String mensaje) {
        super(mensaje);
    }
}
