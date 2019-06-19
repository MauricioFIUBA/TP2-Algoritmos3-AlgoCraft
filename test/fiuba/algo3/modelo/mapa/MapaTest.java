package fiuba.algo3.modelo.mapa;

import fiuba.algo3.modelo.jugador.Jugador;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapaTest {
    @Test
    public void test01SeCreaUnMapaDeJuegoConUnaCantidadDeLugares() {
        Mapa mapa = new Mapa(100);

        assertEquals(mapa.obtenerCapacidadDelMapa(), 100 * 100);
    }
    @Test
    public void test02SeCreaUnMapaDeJuegoYSeLePasaUnNumeroNegativoYTomaSuAbsoluto() {
        Mapa mapa = new Mapa(-100);

        assertEquals(mapa.obtenerCapacidadDelMapa(), 100 * 100);
    }
    @Test
    public void test03SeVerificaQueSePuedaOcuparUnLugarVacio() {
        Mapa mapa = new Mapa(100);
        Madera madera = new Madera();
        Posicion posicionEnElMapa = new Posicion(0, 0);
        madera.setPosicion(posicionEnElMapa);
        mapa.añadirElemento(madera);

        assertEquals(mapa.obtenerCapacidadDelMapa(), (100 * 100) - 1);
        assertTrue(mapa.perteneceAlMapa(madera.obtenerPosicion()));
    }

    @Test
    public void test04SeVerificaQueUnElementoNoPerteceAlMapa() {
        Mapa mapa = new Mapa(100);
        Madera madera = new Madera();

        assertFalse(mapa.perteneceAlMapa(madera.obtenerPosicion()));
    }

    @Test
    public void test05SeVerificaQueNoSePuedeOcuparUnCasilleroOcupadoDelMapa() {
        Mapa mapa = new Mapa(10);
        Madera madera = new Madera();
        madera.setPosicion(new Posicion(0, 0));
        mapa.añadirElemento(madera);
        Metal metal = new Metal();
        metal.setPosicion(new Posicion(0, 0));
        mapa.añadirElemento(metal);

        assertTrue(mapa.perteneceAlMapa(metal.obtenerPosicion()));    //La posicion del metal pertenece, esta es igual a la de la madera
        assertEquals(mapa.obtenerCapacidadDelMapa(), 99);//Y aca se verifica que no se guardo el metal
    }

    @Test
    public void test06SeVerificaQueUnCasilleroPuedeSerOcupadoPorUnPersonaje() {
        Mapa mapa = new Mapa(10);
        Jugador jugador = new Jugador();
        jugador.setPosicion(new Posicion(0, 0));
        mapa.añadirElemento(jugador);

        assertTrue(mapa.perteneceAlMapa(jugador.obtenerPosicion()));
    }
}

