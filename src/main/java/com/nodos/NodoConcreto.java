package com.nodos;

import com.bloques.Bloque;
import com.personaje.Personaje;

//No se si esta commiteado
public class NodoConcreto implements Nodo {

    Nodo siguiente = new NodoNulo();
    Bloque bloque;

    public NodoConcreto (Bloque bloque){
        this.bloque = bloque;
    }

    @Override
    public Nodo copiar(){
       NodoConcreto nuevoNodo = new NodoConcreto(this.bloque.copia());
       return nuevoNodo;
    }

    @Override
    public void insertarSiguiente(Nodo siguiente) {
        if (siguiente.getClass() == NodoNulo.class)
            System.out.println("EL nuevo siguiente en nulo");
        System.out.println(this.siguiente.toString());
        System.out.println("Pasa a ser el siguiente viejo");
        System.out.println("");
        System.out.println(siguiente.toString());
        System.out.println("Pasa a ser el siguiente nuevo");
        System.out.println("");

        Nodo anteriorSiguiente = this.siguiente;
        this.siguiente = siguiente;

        System.out.println(this.siguiente.ultimoSiguiente().toString());
        System.out.println("Se le asigna como siguiente:");
        System.out.println(anteriorSiguiente.toString());

        siguiente.ultimoSiguiente().asignarSiguiente(anteriorSiguiente);
    }

    @Override
    public Nodo conseguirSiguiente(){ return this.siguiente;}

    @Override
    public void asignarSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void ejecutar(Personaje personaje) {

        bloque.ejecutarBloque(personaje);
        if (!siguiente.esUltimo())
            siguiente.ejecutar(personaje);
    }

    @Override
    public void invertir(Personaje personaje) {

        bloque.invertirBloque(personaje);
        siguiente.invertir(personaje);
    }

    @Override
    public Nodo ultimoSiguiente() {
        if (siguiente.esUltimo())
            return this;
        return siguiente.ultimoSiguiente();
    }

    @Override
    public boolean esUltimo() {
        return false;
    }

    @Override
    public Nodo primerNodoListaInternaDeBloque(){
        return bloque.primerNodoListaInterna();
    }
}
