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

    Arista unaArista;

    @Mock
    SeccionDibujo seccionDibujoMock;
    LapizBajo lapizBajoMock;

    @Test
    public void test01PersonajeSeCreaConPosicionPedida(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion);

        assertEquals(personaje.posicionActual.x, 1);
        assertEquals(personaje.posicionActual.y, 2);
    }

    @Test
    public void test02PersonajeSeMueve(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion);

        personaje.mover(1,2);

        assertEquals(personaje.posicionActual.x, 2);
        assertEquals(personaje.posicionActual.y, 4);
    }
    @Test
    public void test05PersonajeSeMueve(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion);

        personaje.mover(1,2);

        assertEquals(personaje.posicionActual.x, 2);
        assertEquals(personaje.posicionActual.y, 4);
    }

   /* @Test
    public void test03PersonajeComienzaConLapizLevantado(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion);

        personaje.mover(1,2);

        assertEquals(personaje.posicionActual.x, 2);
        assertEquals(personaje.posicionActual.y, 4);
    }

    @Test
    public void test04SeLeAsignaLapizBajoAPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Personaje personaje = new Personaje(posicion);
        SeccionDibujo seccionDibujo = new SeccionDibujo();

        personaje.asignarLapiz(lapizBajoMock);
    }*/
}
