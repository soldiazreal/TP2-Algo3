import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.bloques.Bloque;
import com.bloques.Individual;
import com.factory.BloqueBajaraLapiz;
import com.factory.BloqueLevantarLapiz;
import com.factory.BloqueMoverAbajo;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class FactoryTests {

    @Test
    public void SeCreaBloqueParaBajarLapizYLoBaja(){
        BloqueBajaraLapiz bloqueBajar = new BloqueBajaraLapiz();
        Individual bloqueRecibido = bloqueBajar.generar();
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
    public void SeCreaBloqueParaLevantarLapizYLoLevanta(){
        BloqueLevantarLapiz bloqueLevantar = new BloqueLevantarLapiz();
        Individual bloqueRecibido = bloqueLevantar.generar();
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
    public void SeCreaBloqueParaMoverAbajoYLoMueveCorrectamente(){
        SeccionDibujo seccionDibujoMock = mock(SeccionDibujo.class);
        Personaje personaje = new Personaje(new Posicion(1,2), seccionDibujoMock);
        BloqueMoverAbajo bloqueMoverAbajo = new BloqueMoverAbajo();
        Individual bloqueRecibido

    }

}
