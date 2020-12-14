package src.main.java.com.acciones;
import src.main.java.com.personaje.*;


interface Accion{

    public abstract void invertir(Personaje unPersonaje);

    public abstract void accionar(Personaje unPersonaje);
}