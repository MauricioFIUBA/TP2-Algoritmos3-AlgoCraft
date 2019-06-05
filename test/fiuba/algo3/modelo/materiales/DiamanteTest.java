package fiuba.algo3.modelo.materiales;

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
