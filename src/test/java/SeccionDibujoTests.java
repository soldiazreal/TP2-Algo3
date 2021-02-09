import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
import com.excepciones.AristaANullException;
import com.lapiz.Lapiz;
import com.lapiz.LapizBajo;
import com.lapiz.LapizLevantado;
import com.personaje.Personaje;
import com.posicion.Posicion;
import com.tablero.SeccionDibujo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
