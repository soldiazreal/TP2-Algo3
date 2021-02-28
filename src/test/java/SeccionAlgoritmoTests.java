import com.acciones.*;
import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionAlgoritmo;
import com.tablero.SeccionDibujo;
import com.bloques.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeccionAlgoritmoTests {

    @Test

    public void test01SeAgregaUnBloqueAlPrincipio(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        Individual bloqueArriba = new Individual(new MoverArriba());
        seccion.agregarBloqueDespuesDe(bloqueArriba,seccion.getNodo());

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);
        Lapiz lapizBajo = new LapizBajo();
        personaje.asignarLapiz(lapizBajo);

        seccion.ejecutar(personaje);

        assertEquals(dibujo.cantidadAristas(),1);
    }

    @Test
    public void test02PuedoAgregarUnBloqueEnPosicionDelMedio(){

        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        Individual bloqueBajarLapiz = new Individual(new BajarLapiz());
        seccion.agregarBloqueDespuesDe(bloqueBajarLapiz,seccion.getNodo());

        Individual bloqueDerecha = new Individual(new MoverDerecha());
        seccion.agregarBloqueDespuesDe(bloqueDerecha,seccion.getNodo().conseguirSiguiente());

        Individual bloqueIzquierda = new Individual(new MoverIzquierda());
        seccion.agregarBloqueDespuesDe(bloqueIzquierda,seccion.getNodo().conseguirSiguiente().conseguirSiguiente());

        Individual derecha = new Individual(new MoverDerecha());
        seccion.agregarBloqueDespuesDe(derecha,seccion.getNodo().conseguirSiguiente().conseguirSiguiente());

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(0,0);
        Personaje personaje = new Personaje(posicion,dibujo);

        seccion.ejecutar(personaje);

        assertEquals(dibujo.cantidadAristas(),3);
        assertEquals(dibujo.getArista(0).getPosicionFinal().getX(),1);
        assertEquals(dibujo.getArista(0).getPosicionFinal().getY(),0);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getX(),2);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getY(),0);
        assertEquals(dibujo.getArista(2).getPosicionFinal().getX(),1);
        assertEquals(dibujo.getArista(2).getPosicionFinal().getY(),0);
    }

    @Test

    public void test03RemuevoUnBloque(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        Individual bloqueAbajo = new Individual(new MoverAbajo());
        seccion.agregarBloqueDespuesDe(bloqueAbajo, seccion.getNodo());

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        Individual bloqueDerecha = new Individual(new MoverDerecha());
        seccion.agregarBloqueDespuesDe(bloqueDerecha,seccion.getNodo());

        seccion.removerSiguienteBloque(seccion.getNodo());

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),1);
        assertEquals(personaje.getPosicionActual().getY(),0);
    }
}
