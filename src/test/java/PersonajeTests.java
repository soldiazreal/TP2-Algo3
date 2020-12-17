import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.lapiz.LapizLevantado;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

public class PersonajeTests {

    @Test
    public void test01PersonajeSeCreaConPosicionPedida(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        assertEquals(personaje.getPosicionActual().getX(), 1);
        assertEquals(personaje.getPosicionActual().getY(), 2);
    }

    @Test
    public void test02PersonajeSeMueve(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        personaje.mover(1,2);

        assertEquals(personaje.getPosicionActual().getX(), 2);
        assertEquals(personaje.getPosicionActual().getY(), 4);
    }

    @Test
    public void test03PersonajeSeCreaConLapizLevantado(){
        SeccionDibujo seccionDibujoMock = Mockito.mock(SeccionDibujo.class);
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion, seccionDibujoMock);

        personaje.mover(1,2);
        Mockito.verify(seccionDibujoMock, times(0)).agregarArista(any(Arista.class));

        assertEquals(personaje.getPosicionActual().getX(), 2);
        assertEquals(personaje.getPosicionActual().getY(), 4);
    }

    @Test
    public void test04SeCambiaLapizAPersonajeYPintaDondeSeMueve(){
        SeccionDibujo seccionDibujoMock = Mockito.mock(SeccionDibujo.class);
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion, seccionDibujoMock);
        LapizBajo lapizBajoMock = Mockito.mock(LapizBajo.class);

        personaje.mover(1,2);
        Mockito.verify(seccionDibujoMock, times(0)).agregarArista(any(Arista.class));

        personaje.asignarLapiz(lapizBajoMock);
        personaje.mover(1,2);
        personaje.mover(1,2);

        Mockito.verify(lapizBajoMock, times(2)).usar(any(Posicion.class), any(Posicion.class), any(SeccionDibujo.class));
       // Mockito.verify(seccionDibujoMock, times(2)).agregarArista(any(Arista.class));

        assertEquals(personaje.getPosicionActual().getX(), 4);
        assertEquals(personaje.getPosicionActual().getY(), 8);
    }
}
