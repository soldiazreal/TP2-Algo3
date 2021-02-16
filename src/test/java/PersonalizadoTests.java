import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.acciones.*;
import com.bloques.*;
import com.excepciones.ListaNullException;
import com.excepciones.PersonajeNullException;
import com.personaje.Personaje;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PersonalizadoTests {

    @Test
    public void test01SeGuardaAlgoritmoPersonalizado (){
        Personalizado personalizado = new Personalizado();

        List<Bloque> algoritmo = new ArrayList<>();
        Individual moverDerecha = new Individual(new MoverDerecha());
        Individual moverArriba = new Individual(new MoverArriba());
        Individual bajarLapiz = new Individual(new BajarLapiz());
        algoritmo.add(moverDerecha);
        algoritmo.add(moverArriba);
        algoritmo.add(bajarLapiz);

        personalizado.guardarAlgoritmo(algoritmo);

        Personaje personajeMock = mock(Personaje.class);

        personalizado.ejecutarBloque(personajeMock);

        InOrder inOrder = Mockito.inOrder(personajeMock);
        inOrder.verify(personajeMock).mover(1,0);
        inOrder.verify(personajeMock).mover(0,1);
        inOrder.verify(personajeMock).asignarLapiz(any());
    }

    @Test
    public void test02SeEjecutaPersonalizadoConIndividualesDentro(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        Individual moverDerecha = new Individual(new MoverDerecha());
        Individual moverAbajo = new Individual(new MoverAbajo());
        Individual levantarLapiz = new Individual(new LevantarLapiz());
        Individual bajarLapiz = new Individual(new BajarLapiz());
        algoritmo.add(moverDerecha);
        algoritmo.add(moverAbajo);
        algoritmo.add(levantarLapiz);
        algoritmo.add(bajarLapiz);

        personalizado.guardarAlgoritmo(algoritmo);

        Personaje personajeMock = mock(Personaje.class);

        personalizado.ejecutarBloque(personajeMock);

        verify(personajeMock, times(1)).mover(1,0);
        verify(personajeMock, times(1)).mover(0,-1);
        verify(personajeMock, times(2)).asignarLapiz(any());
    }

    @Test
    public void test03SeEjecutaPersonalizadoConSecuencialesDentro(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        Personaje personajeMock = mock(Personaje.class);

        Individual moverDerecha = new Individual(new MoverDerecha());
        Individual moverArriba = new Individual(new MoverArriba());

        Repeticion repeticion = new Repeticion(2);
        repeticion.agregarBloque(moverArriba);

        Inversion inversion = new Inversion();
        inversion.agregarBloque(moverDerecha);

        algoritmo.add(repeticion);
        algoritmo.add(inversion);

        personalizado.guardarAlgoritmo(algoritmo);
        personalizado.ejecutarBloque(personajeMock);

        verify(personajeMock, times(2)).mover(0,1);
        verify(personajeMock, times(1)).mover(-1, 0);
    }

    @Test
    public void test04SeGuardaAlgoritmoVacio(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        personalizado.guardarAlgoritmo(algoritmo);
        assertEquals(personalizado.cantidadBloques(), 0);
    }

    @Test
    public void test05SeInviertePersonalizadoConIndividualesDentro(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        Individual moverDerecha = new Individual(new MoverDerecha());
        Individual moverAbajo = new Individual(new MoverAbajo());
        Individual levantarLapiz = new Individual(new LevantarLapiz());
        Individual bajarLapiz = new Individual(new BajarLapiz());
        algoritmo.add(moverDerecha);
        algoritmo.add(moverAbajo);
        algoritmo.add(levantarLapiz);
        algoritmo.add(bajarLapiz);

        personalizado.guardarAlgoritmo(algoritmo);

        Personaje personajeMock = mock(Personaje.class);

        personalizado.invertirBloque(personajeMock);

        verify(personajeMock, times(1)).mover(-1, 0);
        verify(personajeMock, times(1)).mover(0, 1);
        verify(personajeMock, times(2)).asignarLapiz(any());
    }

    @Test
    public void test06SeInviertePersonalizadoConSecuencialesDentro(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        Personaje personajeMock = mock(Personaje.class);

        Individual moverDerecha = new Individual(new MoverDerecha());
        Individual moverArriba = new Individual(new MoverArriba());

        Repeticion repeticion = new Repeticion(2);
        repeticion.agregarBloque(moverArriba);

        Inversion inversion = new Inversion();
        inversion.agregarBloque(moverDerecha);

        algoritmo.add(repeticion);
        algoritmo.add(inversion);

        personalizado.guardarAlgoritmo(algoritmo);
        personalizado.invertirBloque(personajeMock);

        verify(personajeMock, times(2)).mover(0,-1);
        verify(personajeMock, times(1)).mover(1, 0);
    }

    @Test
    public void test07SeCopiaPersonalizado(){
        Personalizado personalizado = new Personalizado();
        List<Bloque> algoritmo = new ArrayList<>();
        Personaje personajeMock = mock(Personaje.class);

        Individual moverArriba = new Individual(new MoverArriba());
        algoritmo.add(moverArriba);

        personalizado.guardarAlgoritmo(algoritmo);
        Bloque copia = personalizado.copia();
        copia.ejecutarBloque(personajeMock);

        verify(personajeMock, times(1)).mover(0, 1);
        verifyNoMoreInteractions(personajeMock);
    }

    @Test
    public void test08EjecutarPersonalizadoSinGuardarAlgoritmoNoHaceNada(){
        Personalizado personalizado = new Personalizado();
        Personaje personajeMock = mock(Personaje.class);

        personalizado.ejecutarBloque(personajeMock);

        verifyNoInteractions(personajeMock);
    }

    @Test
    public void test09InvertirPersonalizadoSinGuardarAlgoritmoNoHaceNada(){
        Personalizado personalizado = new Personalizado();
        Personaje personajeMock = mock(Personaje.class);

        personalizado.invertirBloque(personajeMock);

        verifyNoInteractions(personajeMock);
    }

    @Test (expected = PersonajeNullException.class)
    public void test10NoSePuedeEjecutarPersonalizadoConPersonajeNull(){
        Personalizado personalizado = new Personalizado();
        personalizado.ejecutarBloque(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test11NoSePuedeInvertirPersonalizadoConPersonajeNull(){
        Personalizado personalizado = new Personalizado();
        personalizado.invertirBloque(null);
    }

    @Test (expected = ListaNullException.class)
    public void test12NoSePuedeGuardarAlgoritmoConAlgoritmoNull(){
        Personalizado personalizado = new Personalizado();
        personalizado.guardarAlgoritmo(null);
    }
}
