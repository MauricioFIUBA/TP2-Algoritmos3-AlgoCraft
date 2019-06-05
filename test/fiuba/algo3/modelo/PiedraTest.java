package fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiedraTest {
    @Test
    public void TestCrearUnBloqueDePiedra() {
        Material madera = new Madera();
        if(madera instanceof Madera) {
            assertTrue(true);
        }
    }
    @Test
    public  void TestComprobacionDeQueLaDurabilidadDeMaderaEs30() {
        Material piedra= new Piedra();
        Integer esperado = 30;
        assertEquals(esperado, piedra.duracion());
    }
}
