import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.acciones.*;
import com.bloques.*;
import com.excepciones.ListaNullException;
import com.excepciones.PersonajeNullException;
import com.nodos.NodoConcreto;
import com.personaje.Personaje;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;


public class PersonalizadoTests {

    @Test
    public void test01SeGuardaAlgoritmoPersonalizado (){
        Personalizado personalizado = new Personalizado();

        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        algoritmo.insertarSiguiente(new NodoConcreto(new Individual(new MoverDerecha())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new MoverArriba())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new BajarLapiz())));

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
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        algoritmo.insertarSiguiente(new NodoConcreto(new Individual(new MoverDerecha())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new MoverAbajo())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new LevantarLapiz())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new BajarLapiz())));

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
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        Personaje personajeMock = mock(Personaje.class);


        NodoConcreto derecha = new NodoConcreto(new Individual(new MoverDerecha()));
        NodoConcreto arriba = new NodoConcreto(new Individual(new MoverArriba()));

        Repeticion repeticion = new Repeticion(2);
        repeticion.agregarBloque(arriba);

        Inversion inversion = new Inversion();
        inversion.agregarBloque(derecha);

        algoritmo.insertarSiguiente(new NodoConcreto(repeticion));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(inversion));

        personalizado.guardarAlgoritmo(algoritmo);
        personalizado.ejecutarBloque(personajeMock);

        verify(personajeMock, times(2)).mover(0,1);
        verify(personajeMock, times(1)).mover(-1, 0);
    }

    @Test
    public void test04SeGuardaAlgoritmoVacio(){
        Personalizado personalizado = new Personalizado();
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        personalizado.guardarAlgoritmo(algoritmo);
        assertEquals(personalizado.cantidadBloques(), 1);
    }

    @Test
    public void test05SeInviertePersonalizadoConIndividualesDentro(){
        Personalizado personalizado = new Personalizado();
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        algoritmo.insertarSiguiente(new NodoConcreto(new Individual(new MoverDerecha())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new MoverAbajo())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new LevantarLapiz())));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(new Individual(new BajarLapiz())));

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
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        Personaje personajeMock = mock(Personaje.class);

        NodoConcreto derecha = new NodoConcreto(new Individual(new MoverDerecha()));
        NodoConcreto arriba = new NodoConcreto(new Individual(new MoverArriba()));

        Repeticion repeticion = new Repeticion(2);
        repeticion.agregarBloque(arriba);

        Inversion inversion = new Inversion();
        inversion.agregarBloque(derecha);

        algoritmo.insertarSiguiente(new NodoConcreto(repeticion));
        algoritmo.ultimoSiguiente().insertarSiguiente(new NodoConcreto(inversion));

        personalizado.guardarAlgoritmo(algoritmo);
        personalizado.invertirBloque(personajeMock);

        verify(personajeMock, times(2)).mover(0,-1);
        verify(personajeMock, times(1)).mover(1, 0);
    }

    @Test
    public void test07SeCopiaPersonalizado(){
        Personalizado personalizado = new Personalizado();
        NodoConcreto algoritmo = new NodoConcreto(new Inicial());
        Personaje personajeMock = mock(Personaje.class);

        NodoConcreto moverArriba = new NodoConcreto(new Individual(new MoverArriba()));
        algoritmo.insertarSiguiente(moverArriba);

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
