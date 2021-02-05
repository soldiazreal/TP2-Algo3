import com.factory.*;
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

        BloqueMoverArriba genBloqueArriba = new BloqueMoverArriba();
        Individual bloqueArriba = genBloqueArriba.generarIndividual();
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

        //NO FUNCIONA COMO DEBERIA

        SeccionAlgoritmo seccion = new SeccionAlgoritmo();

        BloqueBajaraLapiz genBajarLapiz = new BloqueBajaraLapiz();
        Individual bloqueBajarLapiz = genBajarLapiz.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueBajarLapiz,0);

        BloqueMoverDerecha genBloqueDerecha = new BloqueMoverDerecha();
        Individual bloqueDerecha = genBloqueDerecha.generarIndividual();
        seccion.agregarBloqueEnPosicion(bloqueDerecha,1);

       // BloqueMoverIzquierda genBloqueIzquierda = new BloqueMoverIzquierda();
       // Individual bloqueIzquierda = genBloqueIzquierda.generarIndividual();
       // seccion.agregarBloqueEnPosicion(bloqueIzquierda,2);

        BloqueMoverDerecha genDerecha = new BloqueMoverDerecha();
        Individual derecha = genDerecha.generarIndividual();
        seccion.agregarBloqueEnPosicion(derecha,2);

        SeccionDibujo dibujo = new SeccionDibujo();
        Posicion posicion = new Posicion(1,1);
        Personaje personaje = new Personaje(posicion,dibujo);

        seccion.ejecutar(personaje);

        assertEquals(dibujo.cantidadAristas(),2);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getX(),3);
        assertEquals(dibujo.getArista(1).getPosicionFinal().getY(),1);
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
