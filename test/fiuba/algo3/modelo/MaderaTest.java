package fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MaderaTest {
    @Test
    public void TestCrearUnBloqueDeMadera() {
        Material madera = new Madera();
        if(madera instanceof Madera) {
            assertTrue(true);
        }
    }
    @Test
    public  void TestComprobacionDeQueLaDurabilidadDeMaderaEs10() {
        Material madera = new Madera();
        Integer esperado = 10;
        assertEquals(esperado, madera.duracion());
    }
}
