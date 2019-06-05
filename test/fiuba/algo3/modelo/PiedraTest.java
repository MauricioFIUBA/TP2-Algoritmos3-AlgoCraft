package fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class PiedraTest {
    @Test
    public void TestCrearUnBloqueDePiedra() {
        Material piedra = new Piedra();
        assertThat(piedra, instanceOf(Piedra.class));
    }
    @Test
    public  void TestComprobacionDeQueLaDurabilidadDePiedraEs30() {
        Material piedra= new Piedra();
        Integer esperado = 30;
        assertEquals(esperado, piedra.duracion());
    }
}
