import static org.mockito.Mockito.*;

import com.acciones.MoverAbajo;
import com.acciones.MoverDerecha;
import com.acciones.MoverIzquierda;
import com.bloques.Individual;
import com.excepciones.BloqueInexistenteException;
import com.personaje.Personaje;
import com.tablero.SeccionAlgoritmo;
import com.tablero.SeccionBloques;
import com.tablero.Tablero;
import org.junit.Test;
import org.mockito.Mockito;

public class TableroTests {

    @Test
    public void test01SeAgregaUnBloqueCorrectamente() {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.agregarBloque("MoverArriba", tablero.getPrimerNodo());

        Mockito.verify(bloquesMock, Mockito.times(1)).buscarBloque("MoverArriba");
        Mockito.verify(algoritmoMock, Mockito.times(1)).agregarBloqueDespuesDe(null, tablero.getPrimerNodo());
    }

    @Test
    public void test02SeRemueveUnBloqueCorrectamente() {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.removerBloque(tablero.getPrimerNodo());

        Mockito.verify(algoritmoMock, Mockito.times(1)).removerSiguienteBloque(tablero.getPrimerNodo());
    }

    @Test
    public void test03SeIniciaAlgoritmoCorrectamente() {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.iniciarAlgoritmo();

        Mockito.verify(algoritmoMock, Mockito.times(1)).ejecutar(any(Personaje.class));
    }

    @Test(expected = BloqueInexistenteException.class)
    public void test04NoSePuedeAgregarBloqueInexistente() {
        Tablero tablero = new Tablero();
        tablero.agregarBloque("Inexistente", tablero.getPrimerNodo());
    }

    @Test
    public void test05seGeneraElPersonalizado() {
        Tablero tablero = new Tablero();

        SeccionAlgoritmo seccionAlgoritmos = new SeccionAlgoritmo();
        SeccionBloques seccionBloquesMock = mock(SeccionBloques.class);

        seccionAlgoritmos.agregarBloqueDespuesDe(new Individual(new MoverDerecha()), tablero.getPrimerNodo());
        seccionAlgoritmos.agregarBloqueDespuesDe(new Individual(new MoverIzquierda()), tablero.getPrimerNodo().conseguirSiguiente());
        seccionAlgoritmos.agregarBloqueDespuesDe(new Individual(new MoverAbajo()), tablero.getPrimerNodo().conseguirSiguiente().conseguirSiguiente());

        tablero.setSeccionBloquesYAlgoritmos(seccionBloquesMock,seccionAlgoritmos);

        tablero.generarPersonalizado("Personalizado1");

        verify(seccionBloquesMock, times(1)).agregarBloque(eq("Personalizado1"),any());

    }
}
