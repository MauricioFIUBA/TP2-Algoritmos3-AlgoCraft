package fiuba.algo3.modelo.materiales;

import org.junit.Test;
import fiuba.algo3.modelo.herramientas.*;

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

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnHachaDeMetalYNoBajaSuDurabilidad() {
        Material metal = new Metal();
        Hacha hacha = new Hacha(new Metal());
        Integer esperado = metal.duracion();
        metal.desgastarse(hacha);
        assertEquals(esperado, metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoDePiedraYBajaSuDurabilidad() {
        Material metal = new Metal();
        Pico pico = new Pico(new Piedra());
        Integer esperado = metal.duracion();
        metal.desgastarse(pico);
        assertEquals(esperado - 4, metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoDeMaderaYNoBajaSuDurabilidad() {
        Material metal = new Metal();
        Pico pico = new Pico(new Madera());
        Integer esperado = metal.duracion();
        metal.desgastarse(pico);
        assertEquals(esperado, metal.duracion());

    }



    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoFinoYBajaSuDurabilidad() {
        Material metal = new Metal();
        PicoFino picoFino = new PicoFino();
        Integer esperado = metal.duracion();
        metal.desgastarse(picoFino);
        assertEquals(esperado - 20, metal.duracion());

    }
}
