import static org.junit.Assert.*;

import com.acciones.*;
import com.excepciones.PersonajeNullException;
import com.lapiz.LapizBajo;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;



public class AccionesTests {

    @Test
    public void test01BajarLapizInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        BajarLapiz accion = new BajarLapiz();
        accion.accionar(personaje);

        personaje.mover(1,0);

        assertEquals(seccionDibujado.cantidadAristas(),1);
    }

    @Test
    public void test02LevantarElLapizInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        LevantarLapiz accion = new LevantarLapiz();
        accion.accionar(personaje);

        personaje.mover(1,0);

        assertEquals(seccionDibujado.cantidadAristas(),0);
    }

    @Test
    public void test03MoverAbajoMueveAlPersonaje(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

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

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

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

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

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


        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        MoverIzquierda accion = new MoverIzquierda();
        accion.accionar(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test07MoverAbajoInversoMuevePersonajeArriba(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(1,3);

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        MoverAbajo accion = new MoverAbajo();
        accion.invertir(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test08MoverArribaInversoMuevePersonajeAbajo(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        MoverArriba accion = new MoverArriba();
        accion.invertir(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test09MoverDerechaInversoMuevePersonajeIzquierda(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(0,2);

        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        MoverDerecha accion = new MoverDerecha();
        accion.invertir(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());

    }

    @Test
    public void test10MoverIzquierdaInvertidaMuevePersonajeDerecha(){
        Posicion posicion = new Posicion(1,2);
        Posicion posicionEsperada = new Posicion(2,2);


        Personaje personaje = new Personaje(posicion, new SeccionDibujo());

        MoverIzquierda accion = new MoverIzquierda();
        accion.invertir(personaje);

        Posicion posicionActual = personaje.getPosicionActual();

        assertEquals(posicionActual.getX(),posicionEsperada.getX());
        assertEquals(posicionActual.getY(),posicionEsperada.getY());
    }

    @Test
    public void test11BajarLapizInvertidoInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        BajarLapiz accion = new BajarLapiz();
        accion.invertir(personaje);

        personaje.mover(1,0);

        assertEquals(seccionDibujado.cantidadAristas(),0);
    }

    @Test
    public void test12LevantarElLapizInvertidoInyectaCorrectamenteElLapiz(){
        Posicion posicion = new Posicion(1,2);

        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        LevantarLapiz accion = new LevantarLapiz();
        accion.invertir(personaje);

        personaje.mover(1,0);

        assertEquals(seccionDibujado.cantidadAristas(),1);
    }

    @Test
    public void test13MoverAbajoConLapizBajoModificaDibujo(){
        Posicion posicion = new Posicion(1,2);
        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        personaje.asignarLapiz(new LapizBajo());
        MoverAbajo accion = new MoverAbajo();
        accion.accionar(personaje);

        assertEquals(seccionDibujado.cantidadAristas(),1);
    }

    @Test
    public void test14MoverArribaConLapizBajoModificaDibujo(){
        Posicion posicion = new Posicion(1,2);
        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        personaje.asignarLapiz(new LapizBajo());
        MoverArriba accion = new MoverArriba();
        accion.accionar(personaje);

        assertEquals(seccionDibujado.cantidadAristas(),1);

    }

    @Test
    public void test15MoverDerechaConLapizBajoModificaDibujo(){
        Posicion posicion = new Posicion(1,2);
        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        personaje.asignarLapiz(new LapizBajo());
        MoverDerecha accion = new MoverDerecha();
        accion.accionar(personaje);

        assertEquals(seccionDibujado.cantidadAristas(),1);
    }

    @Test
    public void test16MoverIzquierdaConLapizBajoModificaDibujo(){
        Posicion posicion = new Posicion(1,2);
        SeccionDibujo seccionDibujado = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion, seccionDibujado);

        assertEquals(seccionDibujado.cantidadAristas(),0);

        personaje.asignarLapiz(new LapizBajo());
        MoverIzquierda accion = new MoverIzquierda();
        accion.accionar(personaje);

        assertEquals(seccionDibujado.cantidadAristas(),1);
    }

    @Test (expected = PersonajeNullException.class)
    public void test17BajarLapizPersonajeNull(){
        BajarLapiz accion = new BajarLapiz();
        accion.accionar(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test18LevantarLapizPersonajeNull(){
        LevantarLapiz accion = new LevantarLapiz();
        accion.accionar(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test19MoverDerechaPersonajeNull(){
        MoverDerecha accion = new MoverDerecha();
        accion.accionar(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test20MoverIzquierdaPersonajeNull(){
        MoverIzquierda accion = new MoverIzquierda();
        accion.accionar(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test21MoverArribaPersonajeNull(){
        MoverArriba accion = new MoverArriba();
        accion.accionar(null);
    }

    @Test (expected = PersonajeNullException.class)
    public void test22MoverAbajoPersonajeNull(){
        MoverAbajo accion = new MoverAbajo();
        accion.accionar(null);
    }

}


