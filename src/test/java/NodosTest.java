import com.acciones.MoverAbajo;
import com.acciones.MoverArriba;
import com.acciones.MoverDerecha;
import com.bloques.Individual;
import com.bloques.Inicial;
import com.personaje.Personaje;
import org.junit.Test;
import com.nodos.*;
import static org.junit.Assert.*;

import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class NodosTest {
    @Test
    public void test01Inserto2nodosYNoSonNulos(){
        NodoConcreto primer = new NodoConcreto(new Inicial());
        NodoConcreto segundo = new NodoConcreto(new Inicial());

        primer.insertarSiguiente(segundo);

        assertEquals(primer.esUltimo(),false);
        assertEquals(primer.conseguirSiguiente().esUltimo(),false);
        assertEquals(primer.conseguirSiguiente().conseguirSiguiente().esUltimo(),true);

    }

    @Test
    public void test02UltimoSiguienteMeDevuelveUltimoNoNulo(){
        NodoConcreto primer = new NodoConcreto(new Inicial());
        NodoConcreto segundo = new NodoConcreto(new Inicial());
        NodoConcreto tercer = new NodoConcreto(new Inicial());

        primer.insertarSiguiente(segundo);
        segundo.insertarSiguiente(tercer);

        assertEquals(primer.ultimoSiguiente(),segundo.conseguirSiguiente());
    }

    @Test
    public void test03InvertirFucnionaCorrectamente(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        Personaje personajeMock = mock(Personaje.class);

        primer.invertir(personajeMock);
        verify(personajeMock, times(1)).mover(-1, 0);
    }

    @Test
    public void test04EjecutarFucnionaCorrectamente(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        Personaje personajeMock = mock(Personaje.class);

        primer.ejecutar(personajeMock);
        verify(personajeMock, times(1)).mover(1, 0);
    }

    @Test
    public void test05SeCopiaCorrectamente(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        Personaje personajeMock = mock(Personaje.class);

        Nodo segundo = primer.copiar();

        segundo.ejecutar(personajeMock);
        verify(personajeMock, times(1)).mover(1, 0);
    }

    @Test
    public void test06SeInsertaCorrectamenteComoSiguiente(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        NodoConcreto segundo = new NodoConcreto(new Individual(new MoverArriba()));
        Personaje personajeMock = mock(Personaje.class);

        primer.insertarSiguiente(segundo);

        primer.ejecutar(personajeMock);
        InOrder inOrder = Mockito.inOrder(personajeMock);
        inOrder.verify(personajeMock, times(1)).mover(1, 0);
        inOrder.verify(personajeMock, times(1)).mover(0, 1);
    }

    @Test
    public void test07InsertarDePorMedio(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        NodoConcreto segundo = new NodoConcreto(new Individual(new MoverArriba()));
        NodoConcreto tercer = new NodoConcreto(new Individual(new MoverAbajo()));

        Personaje personajeMock = mock(Personaje.class);

        primer.insertarSiguiente(segundo);
        primer.insertarSiguiente(tercer);

        primer.ejecutar(personajeMock);

        InOrder inOrder = Mockito.inOrder(personajeMock);
        inOrder.verify(personajeMock, times(1)).mover(1, 0);
        inOrder.verify(personajeMock, times(1)).mover(0, -1);
        inOrder.verify(personajeMock, times(1)).mover(0, 1);
    }

    @Test
    public void test08InsertarDePorMedioInversion(){
        NodoConcreto primer = new NodoConcreto(new Individual(new MoverDerecha()));
        NodoConcreto segundo = new NodoConcreto(new Individual(new MoverArriba()));
        NodoConcreto tercer = new NodoConcreto(new Individual(new MoverAbajo()));

        Personaje personajeMock = mock(Personaje.class);

        primer.insertarSiguiente(segundo);
        primer.insertarSiguiente(tercer);

        primer.invertir(personajeMock);


        InOrder inOrder = Mockito.inOrder(personajeMock);
        inOrder.verify(personajeMock, times(1)).mover(-1, 0);
        inOrder.verify(personajeMock, times(1)).mover(0, 1);
        inOrder.verify(personajeMock, times(1)).mover(0, -1);
    }
}
