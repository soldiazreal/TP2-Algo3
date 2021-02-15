import static org.mockito.Mockito.*;

import com.acciones.*;
import com.bloques.Bloque;
import com.bloques.Individual;
import com.excepciones.AccionANullException;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IndividualTests {

    @Test

    public void test01LaAccionSeEjecutaBien(){
        Posicion posicion = new Posicion(0,0);
        Posicion esperada = new Posicion(0,-1);
        SeccionDibujo dibujo = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion,dibujo);
        MoverAbajo accion = new MoverAbajo();
        Individual bloque = new Individual(accion);
        bloque.ejecutarBloque(personaje);

        assertEquals(posicion.getX(),esperada.getX());
        assertEquals(posicion.getY(),esperada.getY());
    }

    @Test

    public void test02LaAccionSeInvierteBien(){
        Posicion posicion = new Posicion(0,0);
        Posicion esperada = new Posicion(0,1);
        SeccionDibujo dibujo = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion,dibujo);
        MoverAbajo accion = new MoverAbajo();
        Individual bloque = new Individual(accion);
        bloque.invertirBloque(personaje);

        assertEquals(posicion.getX(),esperada.getX());
        assertEquals(posicion.getY(),esperada.getY());
    }

    @Test (expected = AccionANullException.class)
    public void test03NoSePuedeCrearIndividualConAccionANull(){
        new Individual ( null);
    }

    @Test
    public void test04SeCopiaIndividual(){
        Individual moverIzquierda = new Individual(new MoverIzquierda());
        Bloque copia = moverIzquierda.copia();

        Personaje personajeMock = mock(Personaje.class);

        copia.ejecutarBloque(personajeMock);
        verify(personajeMock, times(1)).mover(-1, 0);
    }
}
