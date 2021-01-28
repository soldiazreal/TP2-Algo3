import com.factory.BloqueLevantarLapiz;
import com.factory.BloqueMoverAbajo;
import com.factory.BloqueMoverArriba;
import com.factory.BloqueMoverDerecha;
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

        BloqueMoverArriba genBloqueArriba = new BloqueMoverArriba();
        Individual bloqueArriba = genBloqueArriba.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueArriba,0);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),1);
        assertEquals(personaje.getPosicionActual().getY(),2);
    }

    @Test
    public void test02PuedoAgregarUnBloqueEnPosicion(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        BloqueMoverAbajo genBloqueAbajo = new BloqueMoverAbajo();
        Individual bloqueAbajo = genBloqueAbajo.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueAbajo,0);

        BloqueLevantarLapiz genBloqueLapiz = new BloqueLevantarLapiz();
        Individual bloqueLapiz = genBloqueLapiz.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueLapiz,1);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        BloqueMoverDerecha genBloqueDerecha = new BloqueMoverDerecha();
        Individual bloqueDerecha = genBloqueDerecha.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),2);
        assertEquals(personaje.getPosicionActual().getY(),0);
    }

    @Test

    public void test03RemuevoUnBloque(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        BloqueMoverAbajo genBloqueAbajo = new BloqueMoverAbajo();
        Individual bloqueAbajo = genBloqueAbajo.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueAbajo,0);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        BloqueMoverDerecha genBloqueDerecha = new BloqueMoverDerecha();
        Individual bloqueDerecha = genBloqueDerecha.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        seccion.removerBloqueDePosicion(0);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),2);
        assertEquals(personaje.getPosicionActual().getY(),1);
    }
}
