import static org.junit.Assert.*;

import com.arista.Arista;
import com.excepciones.AristaANullException;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;

public class SeccionDibujoTests {

    @Test
    public void test01SeAgregaAristaEnListaDeAristas (){
        SeccionDibujo unaSeccionDibujo = new SeccionDibujo();
        Posicion posicionInicio = new Posicion(1,0);
        Posicion posicionFin = new Posicion(0, 1);
        unaSeccionDibujo.agregarArista(new Arista(posicionInicio, posicionFin));
        assertEquals(unaSeccionDibujo.cantidadAristas(), 1 );
    }

    @Test
    public void test02SeCreaSeccionDibujoSinAristas (){
        SeccionDibujo unaSeccionDibujo = new SeccionDibujo();
        assertEquals(unaSeccionDibujo.cantidadAristas(), 0 );
    }

    @Test (expected = AristaANullException.class)
    public void test03NoSePuedeAgregarAristaANull(){
        SeccionDibujo seccionDibujo = new SeccionDibujo();
        seccionDibujo.agregarArista(null);
    }
}
