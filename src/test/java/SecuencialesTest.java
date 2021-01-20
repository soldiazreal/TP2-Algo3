import static org.junit.Assert.*;

import com.factory.BloqueMoverArriba;
import com.factory.BloqueMoverDerecha;
import com.factory.BloqueMoverIzquierda;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import com.bloques.*;

public class SecuencialesTest {

    @Test
    public void test01BloqueInversionInvierteIndividuales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-2,0);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);
        BloqueMoverDerecha generador = new BloqueMoverDerecha();

        Individual primerBloque = generador.generarIndividual();
        Individual segundoBloque = generador.generarIndividual();

        Inversion bloqueInversion = new Inversion(primerBloque);
        bloqueInversion.agregarBloque(segundoBloque);

        bloqueInversion.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test02BloqueInversionInvierteSecuenciales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(2,0);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);

        BloqueMoverDerecha generadorDerecha = new BloqueMoverDerecha();

        Individual primerBloque = generadorDerecha.generarIndividual();

        Inversion bloqueInversionSecundario = new Inversion(primerBloque);
        bloqueInversionSecundario.agregarBloque(primerBloque);

        Inversion bloqueInversionPrimario = new Inversion(bloqueInversionSecundario);

        bloqueInversionPrimario.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test03BloqueInversionInvierteIndividualesYSecuenciales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-1,1);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);

        BloqueMoverDerecha generadorDerecha = new BloqueMoverDerecha();
        BloqueMoverArriba generadorArriba = new BloqueMoverArriba();

        Individual primerBloque = generadorDerecha.generarIndividual();
        Individual segundoBloque = generadorDerecha.generarIndividual();
        Individual tercerBloque = generadorArriba.generarIndividual();
        Individual cuartoBloque = generadorDerecha.generarIndividual();


        Inversion bloqueInversionSecundario = new Inversion(tercerBloque);
        bloqueInversionSecundario.agregarBloque(cuartoBloque);

        Inversion bloqueInversionPrimario = new Inversion(primerBloque);
        bloqueInversionPrimario.agregarBloque(segundoBloque);
        bloqueInversionPrimario.agregarBloque(bloqueInversionSecundario);


        bloqueInversionPrimario.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test04BloqueRepeticionRepiteIndividuales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(2,0);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);
        BloqueMoverDerecha generador = new BloqueMoverDerecha();

        Individual primerBloque = generador.generarIndividual();

        Repeticion bloqueRepeticion = new Repeticion(primerBloque,2);

        bloqueRepeticion.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test05BloqueRepeticionRepiteSecuenciales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-2,0);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);

        BloqueMoverDerecha generadorDerecha = new BloqueMoverDerecha();

        Individual primerBloque = generadorDerecha.generarIndividual();

        Inversion bloqueInversionSecundario = new Inversion(primerBloque);

        Repeticion bloqueRepeticionPrimario = new Repeticion(bloqueInversionSecundario,2);

        bloqueRepeticionPrimario.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test06BloqueRepeticionRepiteIndividualesYSecuenciales(){
        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-4,-2);

        SeccionDibujo nuevaSeccion = new SeccionDibujo();
        Personaje unPersonaje = new Personaje(posicionActual,nuevaSeccion);

        BloqueMoverDerecha generadorDerecha = new BloqueMoverDerecha();
        BloqueMoverIzquierda generadorIzquierda = new BloqueMoverIzquierda();
        BloqueMoverArriba generadorArriba = new BloqueMoverArriba();


        Individual primerBloque = generadorDerecha.generarIndividual();
        Individual segundoBloque = generadorArriba.generarIndividual();
        Individual tercerBloque = generadorIzquierda.generarIndividual();


        Inversion bloqueInversionSecundario = new Inversion(primerBloque);
        bloqueInversionSecundario.agregarBloque(segundoBloque);

        Repeticion bloqueRepeticionPrimario = new Repeticion(bloqueInversionSecundario,2);
        bloqueRepeticionPrimario.agregarBloque(tercerBloque);

        bloqueRepeticionPrimario.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());

    }

}
