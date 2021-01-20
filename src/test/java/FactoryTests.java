import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.bloques.Individual;
import com.bloques.*;
import com.bloques.Repeticion;
import com.bloques.Secuencial;
import com.factory.*;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import org.mockito.Mockito;

public class FactoryTests {

    @Test
    public void test01SeCreaBloqueParaBajarLapizYLoBaja(){
        BloqueBajaraLapiz bloqueBajar = new BloqueBajaraLapiz();
        Individual bloqueRecibido = bloqueBajar.generarIndividual();
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);
        Posicion posicionActual = new Posicion(2,4);
        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),personaje.getPosicionActual().getX());

        personaje.mover(1, 1);

        assertEquals(posicionActual.getY(),personaje.getPosicionActual().getY());

        Mockito.verify(seccionDibujoMock, Mockito.times(1)).agregarArista(any(Arista.class));
    }

    @Test
    public void test02SeCreaBloqueParaLevantarLapizYLoLevanta(){
        BloqueLevantarLapiz bloqueLevantar = new BloqueLevantarLapiz();
        Individual bloqueRecibido = bloqueLevantar.generarIndividual();
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);
        Posicion posicionActual = new Posicion(2,4);
        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),personaje.getPosicionActual().getX());

        personaje.mover(1, 1);

        assertEquals(posicionActual.getY(),personaje.getPosicionActual().getY());

        Mockito.verify(seccionDibujoMock, Mockito.times(0)).agregarArista(any(Arista.class));
    }

    @Test
    public void test03SeCreaBloqueParaMoverAbajoYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);
        Personaje personaje = new Personaje(new Posicion(1,2), seccionDibujoMock);
        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();
        Individual bloqueRecibido = bloqueMoverAbajo.generarIndividual();

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(1, personaje.getPosicionActual().getX());
        assertEquals(1, personaje.getPosicionActual().getY());
    }

    @Test
    public void test04SeCreaBloqueParaMoverArribaYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);
        Personaje personaje = new Personaje(new Posicion(1,2), seccionDibujoMock);
        BloqueMoverArriba bloqueMoverArriba = new BloqueMoverArriba();
        Individual bloqueRecibido = bloqueMoverArriba.generarIndividual();

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(1, personaje.getPosicionActual().getX());
        assertEquals(3, personaje.getPosicionActual().getY());
    }

    @Test
    public void test05SeCreaBloqueParaMoverDerechaYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);

        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(1,0);

        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);
        BloqueMoverDerecha bloqueMoverDerecha = new BloqueMoverDerecha();
        Individual bloqueRecibido = bloqueMoverDerecha.generarIndividual();

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test06SeCreaBloqueParaMoverIzquierdaYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);

        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-1,0);

        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        Individual bloqueRecibido = bloqueMoverIzquierda.generarIndividual();

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test07SeCreaBloqueRepeticionDobleYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);

        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-4,0);

        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        Individual bloqueInicial = bloqueMoverIzquierda.generarIndividual();
        Individual bloqueSecundario = bloqueMoverIzquierda.generarIndividual();

        BloqueRepetirDoble bloqueRepeticionDoble = new BloqueRepetirDoble();
        Repeticion bloqueRecibido = bloqueRepeticionDoble.generarSecuencia(bloqueInicial);
        bloqueRecibido.agregarBloque(bloqueSecundario);

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test08SeCreaBloqueRepeticionTripleYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);

        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(-6,0);

        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        Individual bloqueInicial = bloqueMoverIzquierda.generarIndividual();
        Individual bloqueSecundario = bloqueMoverIzquierda.generarIndividual();

        BloqueRepetirTriple bloqueRepeticionTriple = new BloqueRepetirTriple();
        Repeticion bloqueRecibido = bloqueRepeticionTriple.generarSecuencia(bloqueInicial);
        bloqueRecibido.agregarBloque(bloqueSecundario);

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test09SeCreaBloqueInvertirYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);

        Posicion posicionActual = new Posicion(0,0);
        Posicion posicionEsperada = new Posicion(2,0);

        Personaje personaje = new Personaje(posicionActual, seccionDibujoMock);
        BloqueMoverIzquierda bloqueMoverIzquierda = new BloqueMoverIzquierda();
        Individual bloqueInicial = bloqueMoverIzquierda.generarIndividual();
        Individual bloqueSecundario = bloqueMoverIzquierda.generarIndividual();

        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        Inversion bloqueRecibido = bloqueInvertir.generarSecuencia(bloqueInicial);
        bloqueRecibido.agregarBloque(bloqueSecundario);

        bloqueRecibido.ejecutarBloque(personaje);

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }
}
