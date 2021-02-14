import com.bloques.*;
import com.excepciones.BloqueInexistenteException;
import com.personaje.Personaje;
import com.tablero.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class SeccionBloquesTests {

    @Test
    public void test01SeBuscaYEncuentraBloqueMoverArriba () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueMoverArriba = seccionBloques.buscarBloque("MoverArriba");

        Personaje personajeMock = mock(Personaje.class);

        bloqueMoverArriba.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).mover(0,1);
    }

    @Test
    public void test02SeBuscaYEncuentraBloqueMoverAbajo () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueMoverAbajo = seccionBloques.buscarBloque("MoverAbajo");

        Personaje personajeMock = mock(Personaje.class);

        bloqueMoverAbajo.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).mover(0,-1);
    }

    @Test
    public void test03SeBuscaYEncuentraBloqueMoverDerecha () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueMoverDerecha = seccionBloques.buscarBloque("MoverDerecha");

        Personaje personajeMock = mock(Personaje.class);

        bloqueMoverDerecha.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).mover(1,0);
    }

    @Test
    public void test04SeBuscaYEncuentraBloqueMoverIzquierda () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueMoverIzquierda = seccionBloques.buscarBloque("MoverIzquierda");

        Personaje personajeMock = mock(Personaje.class);

        bloqueMoverIzquierda.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).mover(-1,0);
    }


    @Test
    public void test05SeBuscaYEncuentraBloqueBajarLapiz () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueBajarLapiz = seccionBloques.buscarBloque("BajarLapiz");

        Personaje personajeMock = mock(Personaje.class);

        bloqueBajarLapiz.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).asignarLapiz(any());
        //No se que tan legal es usar any() pero me soluciona el problema
    }

    @Test
    public void test06SeBuscaYEncuentraBloqueLevantarLapiz () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueLevantarLapiz = seccionBloques.buscarBloque("LevantarLapiz");

        Personaje personajeMock = mock(Personaje.class);

        bloqueLevantarLapiz.ejecutarBloque(personajeMock);

        Mockito.verify(personajeMock, Mockito.times(1)).asignarLapiz(any());
    }

    @Test
    public void test07SeBuscaYEncuentraBloqueInversion () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueInversion = seccionBloques.buscarBloque("Invertir");

        assertEquals(bloqueInversion.getClass(), Inversion.class);
    }

    @Test
    public void test08SeBuscanYEncuentranBloquesRepeticion () {
        SeccionBloques seccionBloques = new SeccionBloques();
        Bloque bloqueRepeticionDoble = seccionBloques.buscarBloque("RepetirDoble");
        Bloque bloqueRepeticionTriple = seccionBloques.buscarBloque("RepetirTriple");

        assertEquals(bloqueRepeticionDoble.getClass(), Repeticion.class);
        assertEquals(bloqueRepeticionTriple.getClass(), Repeticion.class);
    }

    @Test
    public void test09SePuedeAgregarYBuscarBloque () {
        SeccionBloques seccionBloques = new SeccionBloques();
        seccionBloques.agregarBloque("Invertir2", new Inversion());
        Bloque bloqueNuevo = seccionBloques.buscarBloque("Invertir2");

        assertEquals(bloqueNuevo.getClass(), Inversion.class);
    }

    @Test (expected = BloqueInexistenteException.class)
    public void test10NoSePuedeBuscarBloqueQueNoExiste (){
        SeccionBloques seccionBloques = new SeccionBloques();
        seccionBloques.buscarBloque("Inexistente");
    }
}
