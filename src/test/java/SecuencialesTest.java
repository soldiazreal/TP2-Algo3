import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.excepciones.ValorInvalidoException;
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

        Individual primerBloque = generador.generarBloque();
        Individual segundoBloque = generador.generarBloque();

        Inversion bloqueInversion = new Inversion();
        bloqueInversion.agregarBloque(primerBloque);
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

        Individual primerBloque = generadorDerecha.generarBloque();

        Inversion bloqueInversionSecundario = new Inversion();
        bloqueInversionSecundario.agregarBloque(primerBloque);
        bloqueInversionSecundario.agregarBloque(primerBloque);

        Inversion bloqueInversionPrimario = new Inversion();
        bloqueInversionPrimario.agregarBloque(bloqueInversionSecundario);

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

        Individual primerBloque = generadorDerecha.generarBloque();
        Individual segundoBloque = generadorDerecha.generarBloque();
        Individual tercerBloque = generadorArriba.generarBloque();
        Individual cuartoBloque = generadorDerecha.generarBloque();


        Inversion bloqueInversionSecundario = new Inversion();
        bloqueInversionSecundario.agregarBloque(tercerBloque);
        bloqueInversionSecundario.agregarBloque(cuartoBloque);

        Inversion bloqueInversionPrimario = new Inversion();
        bloqueInversionPrimario.agregarBloque(primerBloque);
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

        Individual primerBloque = generador.generarBloque();

        Repeticion bloqueRepeticion = new Repeticion(2);
        bloqueRepeticion.agregarBloque(primerBloque);

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

        Individual primerBloque = generadorDerecha.generarBloque();

        Inversion bloqueInversionSecundario = new Inversion();
        bloqueInversionSecundario.agregarBloque(primerBloque);

        Repeticion bloqueRepeticionPrimario = new Repeticion(2);
        bloqueRepeticionPrimario.agregarBloque(bloqueInversionSecundario);

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


        Individual primerBloque = generadorDerecha.generarBloque();
        Individual segundoBloque = generadorArriba.generarBloque();
        Individual tercerBloque = generadorIzquierda.generarBloque();


        Inversion bloqueInversionSecundario = new Inversion();
        bloqueInversionSecundario.agregarBloque(primerBloque);
        bloqueInversionSecundario.agregarBloque(segundoBloque);

        Repeticion bloqueRepeticionPrimario = new Repeticion(2);
        bloqueRepeticionPrimario.agregarBloque(bloqueInversionSecundario);
        bloqueRepeticionPrimario.agregarBloque(tercerBloque);

        bloqueRepeticionPrimario.ejecutarBloque(unPersonaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());

    }

    @Test
    public void test07EjecutarBloqueInversionVacioNoModificaAPersonaje (){
        Inversion bloqueInversion = new Inversion();
        Personaje personajeMock = mock(Personaje.class);

        bloqueInversion.ejecutarBloque(personajeMock);

        verifyNoInteractions(personajeMock);
    }

    @Test
    public void test08EjecutarBloqueRepeticionVacioNoModificaAPersonaje (){
        Repeticion bloqueRepeticion = new Repeticion(1);
        Personaje personajeMock = mock(Personaje.class);

        bloqueRepeticion.ejecutarBloque(personajeMock);

        verifyNoInteractions(personajeMock);
    }

    @Test (expected = ValorInvalidoException.class)
    public void test09NoSePuedeCrearBloqueRepeticionConRepeticionesNegativas (){
        new Repeticion(-1);
    }


    @Test (expected = ValorInvalidoException.class)
    public void test10NoSePuedeCrearBloqueRepeticionConRepeticionesNulas (){
        new Repeticion(0);
    }
}
