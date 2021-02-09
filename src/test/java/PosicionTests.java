import static org.junit.Assert.*;
import com.posicion.Posicion;
import org.junit.Test;

public class PosicionTests {

    @Test
    public void test01SeCreaPosicionValida (){
        Posicion unaPosicion = new Posicion (1,0);
        assertEquals(unaPosicion.getX(), 1);
        assertEquals(unaPosicion.getY(), 0);
    }

    @Test
    public void test02SeModificaPosicion(){
        Posicion unaPosicion = new Posicion(1,0);
        unaPosicion.modificarCoordenadas(2,4);
        assertEquals(unaPosicion.getX(), 3);
        assertEquals(unaPosicion.getY(), 4);
    }

    @Test
    public void test03SeCreaPosicionConValoresNegativos (){
        Posicion posicion = new Posicion(-1, -2);
        assertEquals(posicion.getX(), -1);
        assertEquals(posicion.getY(), -2);
    }

    @Test
    public void test04SeCreaUnaCopiaDePosicion(){
        Posicion posicion = new Posicion(2, 1);
        Posicion copia = posicion.copiaDePosicion();

        assertEquals(posicion.getX(), copia.getX());
        assertEquals(posicion.getY(), copia.getY());
    }
}
