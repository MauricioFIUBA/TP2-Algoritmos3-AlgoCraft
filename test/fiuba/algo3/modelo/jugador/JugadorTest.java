package fiuba.algo3.modelo.jugador;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.herramientas.Herramienta;

import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.modelo.materiales.Madera;
import org.junit.Test;


public class JugadorTest {

    @Test
    public void testSeCreaUnUsuarioConUnaHachaDeMadera() {
        Jugador jugador = new Jugador();
        Herramienta herramientaDePrueba = jugador.showHerramientaEquipada();
        assertTrue(herramientaDePrueba instanceof Hacha);
        assertTrue(herramientaDePrueba.getMaterial() instanceof Madera);
    }
}
