package fiuba.algo3.modelo.materiales;

import org.junit.Test;
import fiuba.algo3.modelo.herramientas.*;

//import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class PiedraTest {
    @Test
    public void testCrearUnBloqueDePiedra() {
        Material piedra = new Piedra();
        assertThat(piedra, instanceOf(Piedra.class));
    }
    @Test
    public  void testComprobacionDeQueLaDurabilidadDePiedraEs30() {
        Material piedra= new Piedra();
        Integer esperado = 30;
        assertEquals(esperado, piedra.duracion());
    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnHachaDePiedraYNoBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Hacha hacha =  new Hacha(new Piedra());
        Integer esperado = piedra.duracion();
        piedra.desgastarse(hacha);
        assertEquals(esperado, piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoDeMetalYNoBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Pico pico = new Pico(new Piedra());
        Integer esperado = piedra.duracion();
        piedra.desgastarse(pico);
        assertEquals(esperado - 4, piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoFinoYBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        PicoFino picoFino = new PicoFino();
        Integer esperado = piedra.duracion();
        piedra.desgastarse(picoFino);
        assertEquals(esperado - 20, piedra.duracion());

    }
}
