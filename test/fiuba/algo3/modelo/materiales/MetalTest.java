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
    public  void testGolpeoUnBloqueDeMetalConUnHachaDeMaderaYNoBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta hacha = new Hacha(new Madera());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(hacha);
        assertEquals(esperado, metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnHachaDePiedraYNoBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta hacha = new Hacha(new Piedra());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(hacha);
        assertEquals(esperado, metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnHachaDeMetalYNoBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta hacha = new Hacha(new Metal());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(hacha);
        assertEquals(esperado, metal.duracion());

    }


    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoDeMaderaYNoBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta pico = new Pico(new Madera());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(pico);
        assertEquals(esperado, metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoDePiedraYBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta pico = new Pico(new Piedra());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(pico);
        assertEquals(esperado - pico.getFuerza(), metal.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoDeMetalYBajaSuDurabilidad() {
        Metal metal = new Metal();
        Herramienta pico = new Pico(new Metal());
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(pico);
        assertEquals(esperado - pico.getFuerza(), metal.duracion());

    }



    @Test
    public  void testGolpeoUnBloqueDeMetalConUnPicoFinoYNoBajaSuDurabilidad() {
        Metal metal = new Metal();
        PicoFino picoFino = new PicoFino();
        Integer esperado = metal.duracion();
        metal.esDesgastadoPor(picoFino);
        assertEquals(esperado - 20, metal.duracion());
    }
}
