package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;
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

    @Test
    public  void testGolpeoUnBloqueDeMaderaConUnHachaDeMaderaYBajaSuDurabilidad() {
        Madera madera = new Madera();
        Hacha hacha = new Hacha(new Madera());
        Integer esperado = madera.duracion();
        madera.desgastarse(hacha);
        assertEquals(esperado - 2, madera.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMaderaConUnPicoDeMaderaYNoBajaSuDurabilidad() {
        Madera madera = new Madera();
        Pico pico = new Pico(new Madera());
        Integer esperado = madera.duracion();
        madera.desgastarse(pico);
        assertEquals(esperado, madera.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeMaderaConUnPicoFinoYNoBajaSuDurabilidad() {
        Madera madera = new Madera();
        PicoFino picoFino = new PicoFino();
        Integer esperado = madera.duracion();
        madera.desgastarse(picoFino);
        assertEquals(esperado, madera.duracion());

    }
}
