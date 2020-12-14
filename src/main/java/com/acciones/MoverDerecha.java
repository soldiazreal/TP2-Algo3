package src.main.java.com.acciones;
import src.main.java.com.personaje.*;


public class MoverDerecha implements Accion{

    public MoverDerecha(){}

    @Override
    public void invertir(Personaje unPersonaje){
        MoverIzquierda accionInversa = new MoverIzquierda();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        unPersonaje.mover(1,0);
    }
}