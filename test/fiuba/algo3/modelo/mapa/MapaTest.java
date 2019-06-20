package fiuba.algo3.modelo.mapa;

import fiuba.algo3.modelo.jugador.Jugador;
import fiuba.algo3.modelo.materiales.*;
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
    public void test04SeVerificaQueUnElementoNoPerteneceAlMapa() {
        Mapa mapa = new Mapa(100);
        Madera madera = new Madera();
        madera.setPosicion(new Posicion(10, 5));
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

    @Test
    public void test07UnaPiedraNoSobrescribaAOtroMaterial() {
        Mapa mapa = new Mapa(10);
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        madera.setPosicion(new Posicion(-1,0));
        piedra.setPosicion(new Posicion(0,-1));
        mapa.añadirElemento(madera);
        mapa.añadirElemento(piedra);
        assertEquals(10*10-2, mapa.obtenerCapacidadDelMapa());
    }
}

