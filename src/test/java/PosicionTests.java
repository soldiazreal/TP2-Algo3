import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arista.Arista;
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

}
