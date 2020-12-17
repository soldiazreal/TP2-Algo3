import com.acciones.*;
import com.bloques.Individual;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BloqueTests {

    @Test

    public void test01ElNombreDelBloqueSeGuardaBien(){

        MoverArriba Arriba = new MoverArriba();
        Individual bloque = new Individual("MoverArriba", Arriba);

        assertEquals(bloque.nombre, "MoverArriba");

    }

    @Test

    public void test02LaAccionSeGuardaBien(){
        MoverAbajo accion = new MoverAbajo();
        Individual bloque = new Individual("MoverAbajo",accion);

        assertEquals(bloque.getAccion(),accion);
    }
}
