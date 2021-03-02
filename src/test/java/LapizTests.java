import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.excepciones.SeccionDibujoNullException;
import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.lapiz.LapizLevantado;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;

public class LapizTests {

    @Test
    public void test01UsarLapizBajoDibujaUnaArista(){
        SeccionDibujo seccionDibujo = new SeccionDibujo ();
        LapizBajo lapiz = new LapizBajo ();

        lapiz.usar(new Posicion(0,0), new Posicion(1,0), seccionDibujo);
        assertEquals(seccionDibujo.cantidadAristas(), 1);
    }

    @Test
    public void test02UsarLapizLevantadoNoDibujaUnaArista() {
        SeccionDibujo seccionDibujo = new SeccionDibujo();
        LapizLevantado lapiz = new LapizLevantado();

        lapiz.usar(new Posicion(0, 0), new Posicion(1, 0), seccionDibujo);
        assertEquals(seccionDibujo.cantidadAristas(), 0);
    }

    @Test (expected = SeccionDibujoNullException.class)
    public void test03NoSePuedeUsarLapizBajoConSeccionDibujoANull (){
        Lapiz lapiz = new LapizBajo();
        lapiz.usar(mock (Posicion.class), mock (Posicion.class), null);
    }
}
