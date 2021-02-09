import static org.mockito.Mockito.*;

import com.excepciones.BloqueInexistenteException;
import com.personaje.Personaje;
import com.tablero.SeccionAlgoritmo;
import com.tablero.SeccionBloques;
import com.tablero.Tablero;
import org.junit.Test;
import org.mockito.Mockito;

public class TableroTests {

    @Test
    public void  test01SeAgregaUnBloqueCorrectamente () {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.agregarBloque("MoverArriba", 2);

        Mockito.verify(bloquesMock, Mockito.times(1)).buscarBloque("MoverArriba");
        Mockito.verify(algoritmoMock, Mockito.times(1)).agregarBloqueEnPosicion(null, 2);
    }

    @Test
    public void  test02SeRemueveUnBloqueCorrectamente () {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.removerBloque(2);

        Mockito.verify(algoritmoMock, Mockito.times(1)).removerBloqueDePosicion(2);
    }

    @Test
    public void  test03SeIniciaAlgoritmoCorrectamente () {
        Tablero tablero = new Tablero();
        SeccionAlgoritmo algoritmoMock = mock(SeccionAlgoritmo.class);
        SeccionBloques bloquesMock = mock(SeccionBloques.class);

        tablero.setSeccionBloquesYAlgoritmos(bloquesMock, algoritmoMock);

        tablero.iniciarAlgoritmo();

        Mockito.verify(algoritmoMock, Mockito.times(1)).ejecutar(any(Personaje.class));
    }

    @Test (expected = BloqueInexistenteException.class)
    public void test04NoSePuedeAgregarBloqueInexistente (){
        Tablero tablero = new Tablero();
        tablero.agregarBloque("Inexistente", 0);
    }
}
