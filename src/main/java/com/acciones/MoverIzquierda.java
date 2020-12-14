package src.main.java.com.acciones;
import src.main.java.com.personaje.*;

public class MoverIzquierda implements Accion{

    public MoverIzquierda(){}

    @Override
    public void invertir(Personaje unPersonaje){
        MoverDerecha accionInversa = new MoverDerecha();
        accionInversa.accionar(unPersonaje);
    }

    @Override
    public void accionar(Personaje unPersonaje){
        unPersonaje.mover(-1,0);
    }
}