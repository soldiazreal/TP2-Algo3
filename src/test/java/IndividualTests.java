import com.acciones.*;
import com.bloques.Individual;
import com.excepciones.AccionANullException;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IndividualTests {

    @Test

    public void test01ElNombreDelBloqueSeGuardaBien(){

        MoverArriba Arriba = new MoverArriba();
        Individual bloque = new Individual("MoverArriba", Arriba);

        assertEquals(bloque.getNombre(), "MoverArriba");

    }

    @Test

    public void test02LaAccionSeEjecutaBien(){
        Posicion posicion = new Posicion(0,0);
        Posicion esperada = new Posicion(0,-1);
        SeccionDibujo dibujo = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion,dibujo);
        MoverAbajo accion = new MoverAbajo();
        Individual bloque = new Individual("MoverAbajo",accion);
        bloque.ejecutarBloque(personaje);

        assertEquals(posicion.getX(),esperada.getX());
        assertEquals(posicion.getY(),esperada.getY());
    }

    @Test

    public void test03LaAccionSeInvierteBien(){
        Posicion posicion = new Posicion(0,0);
        Posicion esperada = new Posicion(0,1);
        SeccionDibujo dibujo = new SeccionDibujo();
        Personaje personaje = new Personaje(posicion,dibujo);
        MoverAbajo accion = new MoverAbajo();
        Individual bloque = new Individual("MoverAbajo",accion);
        bloque.invertirBloque(personaje);

        assertEquals(posicion.getX(),esperada.getX());
        assertEquals(posicion.getY(),esperada.getY());
    }

    @Test (expected = AccionANullException.class)
    public void test04NoSePuedeCrearIndividualConAccionANull(){
        new Individual ("Bloque", null);
    }
}
