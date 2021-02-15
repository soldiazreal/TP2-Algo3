import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.acciones.MoverArriba;
import com.acciones.MoverDerecha;
import com.acciones.MoverIzquierda;
import com.excepciones.ValorInvalidoException;
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

        Individual primerBloque = new Individual(new MoverDerecha());
        Individual segundoBloque = new Individual(new MoverDerecha());

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

        Individual primerBloque = new Individual(new MoverDerecha());

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

        Individual primerBloque = new Individual(new MoverDerecha());
        Individual segundoBloque = new Individual(new MoverDerecha());
        Individual tercerBloque = new Individual(new MoverArriba());
        Individual cuartoBloque = new Individual(new MoverDerecha());


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

        Individual primerBloque = new Individual(new MoverDerecha());

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

        Individual primerBloque = new Individual(new MoverDerecha());

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

        Individual primerBloque = new Individual(new MoverDerecha());
        Individual segundoBloque = new Individual(new MoverArriba());
        Individual tercerBloque = new Individual(new MoverIzquierda());


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

    @Test
    public void test11RepeticionesSeCopiaCorrectamente(){
        Repeticion repeticion = new Repeticion(2);
        Individual moverDerecha = new Individual(new MoverDerecha());
        repeticion.agregarBloque(moverDerecha);

        Bloque copia = repeticion.copia();

        Personaje personajeMock = mock(Personaje.class);

        copia.ejecutarBloque(personajeMock);
        verify(personajeMock, times(2)).mover(1,0);
    }

    @Test
    public void test12InversionSeCopiaCorrectamente(){
        Inversion inversion = new Inversion();
        Individual moverDerecha = new Individual(new MoverDerecha());
        inversion.agregarBloque(moverDerecha);

        Bloque copia = inversion.copia();

        Personaje personajeMock = mock(Personaje.class);

        copia.ejecutarBloque(personajeMock);
        verify(personajeMock, times(1)).mover(-1,0);
    }
}
