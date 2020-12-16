import static org.junit.Assert.*;

import com.acciones.*;

import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.lapiz.LapizLevantado;
import com.personaje.Personaje;
import com.posicion.Posicion;
import org.junit.Test;


public class AccionesTests {

    @Test
    public void test01BajarLapizInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        LapizBajo lapizEsperado = new LapizBajo();

        Personaje personaje = new Personaje(posicion);

        BajarLapiz accion = new BajarLapiz();
        accion.accionar(personaje);

        Lapiz lapizActual = personaje.getLapizActual();

        assertEquals(lapizActual.getClass(),lapizEsperado.getClass());
    }

    @Test
    public void test02LevantarElLapizInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        LapizLevantado lapizEsperado = new LapizLevantado();

        Personaje personaje = new Personaje(posicion);

        LevantarLapiz accion = new LevantarLapiz();
        accion.accionar(personaje);

        Lapiz lapizActual = personaje.getLapizActual();

        assertEquals(lapizActual.getClass(),lapizEsperado.getClass());
    }

    @Test
    public void test03MoverAbajoMueveAlPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion);

        MoverAbajo accion = new MoverAbajo();
        accion.accionar(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test04MoverArribaMueveAlPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(1,3);

        Personaje personaje = new Personaje(posicion);

        MoverArriba accion = new MoverArriba();
        accion.accionar(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test05MoverDerechaMueveAlPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(2,2);

        Personaje personaje = new Personaje(posicion);

        MoverDerecha accion = new MoverDerecha();
        accion.accionar(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());

    }

    @Test
    public void test06MoverIzquierdaMueveAlPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(0,2);


        Personaje personaje = new Personaje(posicion);

        MoverIzquierda accion = new MoverIzquierda();
        accion.accionar(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }
}
