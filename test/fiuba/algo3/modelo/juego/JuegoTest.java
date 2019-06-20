package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.mapa.Mapa;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {

    @Test
    public void test01SeInicializaElJuegoConUnTableroDeXPosicionesUnJugadorYConLosElementosDistribuidosEnElMapa() {
        Juego juego = new Juego();
        Mapa mapaDelJuego = juego.getMapa();
        /*Capacidad del mapa(50*50) - maderas(16) - metales(4) - piedras(4) - diamantes(4)*/
        Integer esperado = (20*20)-29;
        Integer elementosDelJuego = mapaDelJuego.obtenerCapacidadDelMapa();

        assertEquals(elementosDelJuego,esperado);
    }
}
