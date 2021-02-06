import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.bloques.Individual;
import com.factory.BloqueBajaraLapiz;
import com.factory.BloqueMoverArriba;
import com.factory.BloqueMoverDerecha;
import com.factory.BloqueMoverIzquierda;
import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.lapiz.LapizLevantado;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionAlgoritmo;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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

}
