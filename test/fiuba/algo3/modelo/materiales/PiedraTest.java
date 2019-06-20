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
    public  void testGolpeoUnBloqueDePiedraConUnHachaDeMaderaYNoBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta hacha =  new Hacha(new Madera());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(hacha);
        assertEquals(esperado, piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnHachaDePiedraYNoBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta hacha =  new Hacha(new Piedra());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(hacha);
        assertEquals(esperado, piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnHachaDeMetalYNoBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta hacha =  new Hacha(new Metal());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(hacha);
        assertEquals(esperado, piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnPicoDeMaderalYBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta pico = new Pico(new Madera());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(pico);
        assertEquals(esperado - pico.getFuerza(), piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnPicoDePiedraYBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta pico = new Pico(new Piedra());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(pico);
        assertEquals(esperado - pico.getFuerza(), piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnPicoDeMetalYBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta pico = new Pico(new Metal());
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(pico);
        assertEquals(esperado - pico.getFuerza(), piedra.duracion());

    }

    @Test
    public  void testGolpeoUnBloqueDePiedraConUnPicoFinoYBajaSuDurabilidad() {
        Piedra piedra  = new Piedra();
        Herramienta picoFino = new PicoFino();
        Integer esperado = piedra.duracion();
        piedra.esDesgastadoPor(picoFino);
        assertEquals(esperado - 20, piedra.duracion());

    }
}