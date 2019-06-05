package fiuba.algo3.modelo.Materiales;

import fiuba.algo3.modelo.Materiales.Material;
import fiuba.algo3.modelo.Materiales.Metal;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MetalTest {
    @Test
    public void testCrearUnBloqueDeMetal() {
        Material metal = new Metal();
        assertThat(metal, instanceOf(Metal.class));
    }

    @Test
    public  void testComprobacionDeQueLaDurabilidadDeMetalEs50() {
        Material metal = new Metal();
        Integer esperado = 50;
        assertEquals(esperado, metal.duracion());
    }
}
