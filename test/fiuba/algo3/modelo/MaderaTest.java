package fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MaderaTest {
    @Test
    public void TestCrearUnBloqueDeMadera() {
        Material madera = new Madera();
        assertThat(madera, instanceOf(Madera.class));
    }
    @Test
    public  void TestComprobacionDeQueLaDurabilidadDeMaderaEs10() {
        Material madera = new Madera();
        Integer esperado = 10;
        assertEquals(esperado, madera.duracion());
    }
}
