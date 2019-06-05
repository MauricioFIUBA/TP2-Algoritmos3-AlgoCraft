package fiuba.algo3.modelo.materiales;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MaderaTest {
    @Test
    public void testCrearUnBloqueDeMadera() {
        Material madera = new Madera();
        assertThat(madera, instanceOf(Madera.class));
    }
    @Test
    public  void testComprobacionDeQueLaDurabilidadDeMaderaEs10() {
        Material madera = new Madera();
        Integer esperado = 10;
        assertEquals(esperado, madera.duracion());
    }
}
