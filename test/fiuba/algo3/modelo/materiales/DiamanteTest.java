package fiuba.algo3.modelo.materiales;

import org.junit.Test;
import fiuba.algo3.modelo.herramientas.*;
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

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnHachaDeMaderaYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Herramienta hacha = new Hacha(new Madera());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(hacha);
        assertEquals(esperado, diamante.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnHachaDePiedraYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Hacha hacha = new Hacha(new Piedra());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(hacha);
        assertEquals(esperado, diamante.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnHachaDeMetalYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Hacha hacha = new Hacha(new Metal());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(hacha);
        assertEquals(esperado, diamante.duracion());
    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoDeMaderaYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Pico pico = new Pico(new Madera());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(pico);
        assertEquals(esperado, diamante.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoDePiedraYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Pico pico = new Pico(new Piedra());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(pico);
        assertEquals(esperado, diamante.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoDeMetalYNoBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Pico pico = new Pico(new Metal());
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(pico);
        assertEquals(esperado, diamante.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDeDiamanteConUnPicoFinoYBajaSuDurabilidad() {
        Diamante diamante  = new Diamante();
        Herramienta picoFino = new PicoFino();
        Integer esperado = diamante.duracion();
        diamante.esDesgastadoPor(picoFino);
        assertEquals(esperado - 20, diamante.duracion());
    }
}
