package fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MetalTest {
    @Test
    public void TestCrearUnBloqueDeMetal() {
        Material metal = new Metal();
        assertThat(metal, instanceOf(Metal.class));
    }

    @Test
    public  void TestComprobacionDeQueLaDurabilidadDeMetalEs50() {
        Material metal = new Metal();
        Integer esperado = 50;
        assertEquals(esperado, metal.duracion());
    }
}
