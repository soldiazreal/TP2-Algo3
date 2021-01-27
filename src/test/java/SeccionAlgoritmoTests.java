import com.factory.BloqueLevantarLapiz;
import com.factory.BloqueMoverAbajo;
import com.factory.BloqueMoverArriba;
import com.factory.BloqueMoverDerecha;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionAlgoritmo;
import com.tablero.SeccionDibujo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeccionAlgoritmoTests {

    @Test

    public void test01SeAgregaUnBloqueAlPrincipio(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        BloqueMoverArriba bloque = new BloqueMoverArriba();
        seccion.agregarBloqueEnPosicion(bloque,0);

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

        BloqueMoverAbajo bloque = new BloqueMoverAbajo();
        seccion.agregarBloqueEnPosicion(bloque,0);

        BloqueLevantarLapiz bloqueLapiz = new BloqueLevantarLapiz();
        seccion.agregarBloqueEnPosicion(bloqueLapiz,1);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        BloqueMoverDerecha bloqueDerecha = new BloqueMoverDerecha();
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),2);
        assertEquals(personaje.getPosicionActual().getY(),0);
    }

    @Test

    public void test03RemuevoUnBloque(){
        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        BloqueMoverAbajo bloque = new BloqueMoverAbajo();
        seccion.agregarBloqueEnPosicion(bloque,0);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);

        Personaje personaje = new Personaje(posicion,dibujo);

        BloqueMoverDerecha bloqueDerecha = new BloqueMoverDerecha();
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

        seccion.removerBloqueDePosicion("MoverAbajo",0);

        seccion.ejecutar(personaje);

        assertEquals(personaje.getPosicionActual().getX(),2);
        assertEquals(personaje.getPosicionActual().getY(),1);
    }
}
