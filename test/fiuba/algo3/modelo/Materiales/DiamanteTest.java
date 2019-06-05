package fiuba.algo3.modelo.Materiales;

import fiuba.algo3.modelo.Materiales.Diamante;
import fiuba.algo3.modelo.Materiales.Material;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;


public class DiamanteTest {
    @Test
    public void testCrearUnBloqueDeDiamante() {
        Material diamante = new Diamante();
        assertThat(diamante, instanceOf(Diamante.class));
    }

    @Test
    public  void testComprobacionDeQueLaDurabilidadDeDiamanteEs100() {
        Material diamante = new Diamante();
        Integer esperado = 100;
        assertEquals(esperado, diamante.duracion());
    }
}
