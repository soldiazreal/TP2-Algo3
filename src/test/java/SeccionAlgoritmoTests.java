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

        Individual bloqueArriba = new Individual("MoverArriba", new MoverArriba());
        seccion.agregarBloqueEnPosicion(bloqueArriba,0);

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

        Individual bloqueBajarLapiz = new Individual("BajarLapiz", new BajarLapiz());
        seccion.agregarBloqueEnPosicion(bloqueBajarLapiz,0);

        Individual bloqueDerecha = new Individual("MoverDerecha", new MoverDerecha());
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        Individual bloqueIzquierda = new Individual("MoverIzquierda", new MoverIzquierda());
        seccion.agregarBloqueEnPosicion(bloqueIzquierda,2);

        Individual derecha = new Individual("MoverDerecha", new MoverDerecha());
        seccion.agregarBloqueEnPosicion(derecha,2);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(0,0);
        Personaje personaje = new Personaje(posicion,dibujo);

        seccion.ejecutar(personaje);

        assertEquals(dibujo.cantidadAristas(),3);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getX(),2);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getY(),0);
    }

    @Test

    public void test03RemuevoUnBloque(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        Individual bloqueAbajo = new Individual("MoverAbajo", new MoverAbajo());
        seccion.agregarBloqueEnPosicion(bloqueAbajo,0);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        Individual bloqueDerecha = new Individual("MoverDerecha", new MoverDerecha());
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        seccion.removerBloqueDePosicion(0);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),2);
        assertEquals(personaje.getPosicionActual().getY(),1);
    }
}
