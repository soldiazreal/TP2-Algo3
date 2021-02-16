import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.excepciones.PosicionANullException;
import com.posicion.Posicion;
import org.junit.Test;

public class AristaTests {

    @Test
    public void test01AristaSeCreaConPosicionesDistintas() {
        Posicion posicionInicial = new Posicion (1, 0);
        Posicion posicionFin = new Posicion (0, 1);
        Arista unaArista = new Arista (posicionInicial, posicionFin);

        assertEquals(unaArista.getPosicionInicial().getX(), posicionInicial.getX());
        assertEquals(unaArista.getPosicionFinal().getY(), posicionFin.getY());
        assertEquals(unaArista.getPosicionInicial().getY(), posicionInicial.getY());
        assertEquals(unaArista.getPosicionFinal().getX(), posicionFin.getX());
    }

    @Test (expected = PosicionANullException.class)
    public void test02NoSePuedeCrearAristaConPosicionInicioANull(){
        new Arista(null, mock(Posicion.class));
    }

    @Test (expected = PosicionANullException.class)
    public void test03NoSePuedeCrearAristaConPosicionFinANull(){
        new Arista(mock(Posicion.class), null);
    }

}
