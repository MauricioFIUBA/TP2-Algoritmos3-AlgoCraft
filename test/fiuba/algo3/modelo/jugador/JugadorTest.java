package fiuba.algo3.modelo.jugador;

import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.herramientas.Herramienta;

import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import org.junit.Test;


public class JugadorTest {

    @Test
    public void test01SeCreaUnUsuarioConUnaHachaDeMadera() {
        Jugador jugador = new Jugador();
        Herramienta herramientaDePrueba = jugador.getHerramientaEquipada();
        assertTrue(herramientaDePrueba instanceof Hacha);
        assertTrue(herramientaDePrueba.getMaterial() instanceof Madera);
    }
    @Test
    public void test02SeVerificaQueElJugadorPuedeMoverseHaciaLaIzquierda(){
        Jugador jugador = new Jugador();
        Posicion posicion = new Posicion(5,5);
        jugador.setPosicion(posicion);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        /*Se crea una regla de movimiento cada vez que se clickee o se quiera mover*/
        Direccion direccionIzquierda = new DireccionIzquierda();
        /*mapa.moverJugador(direccionIzquierda) ya tiene que modificar la pos del jugador si es posible moverse*/
        mapa.moverJugador(direccionIzquierda);
        Posicion posEsperada = new Posicion(4,5);
        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test03SeVerificaQueElJugadorPuedaMoverseHaciaLaDerecha(){
        Jugador jugador = new Jugador();
        Posicion posicion = new Posicion(5,5);
        jugador.setPosicion(posicion);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        Direccion direccionDerecha = new DireccionDerecha();
        mapa.moverJugador(direccionDerecha);
        Posicion posEsperada = new Posicion(6,5);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test04SeVerificaQueElJugadorPuedaMoverseHaciaArriba(){
        Jugador jugador = new Jugador();
        Posicion posicion = new Posicion(5,5);
        jugador.setPosicion(posicion);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        Direccion direccionArriba = new DireccionArriba();
        mapa.moverJugador(direccionArriba);
        Posicion posEsperada = new Posicion(5,4);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test05SeVerificaQueElJugadorPuedaMoverseHaciaAbajo(){
        Jugador jugador = new Jugador();
        Posicion posicion = new Posicion(5,5);
        jugador.setPosicion(posicion);
        Mapa mapa = new Mapa(10);
        Integer capacidad = mapa.obtenerCapacidadDelMapa();
        mapa.añadirJugador(jugador);
        Direccion direccionAbajo = new DireccionAbajo();
        mapa.moverJugador(direccionAbajo);
        Posicion posEsperada = new Posicion(5,6);

        assertEquals(jugador.obtenerPosicion(),posEsperada);

    }
    @Test
    public void test06JugadorIntentaMoverseALaIzquierdaDeLosLimitesDelMapaYSuPosicionNoSeModifica(){
        Jugador jugador = new Jugador();
        Posicion posJugador = new Posicion(0,0);
        jugador.setPosicion(posJugador);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        Direccion direccionIzquierda = new DireccionIzquierda();
        mapa.moverJugador(direccionIzquierda);
        Posicion posEsperada = new Posicion(0,0);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test07JugadorIntentaMoverseALaDerechaDeLosLimetesDelMapaYSuPosicionNoSeModifica(){
        Jugador jugador = new Jugador();
        Posicion posJugador = new Posicion(10,0);
        jugador.setPosicion(posJugador);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        mapa.moverJugador(new DireccionDerecha());
        Posicion posEsperada = new Posicion(10,0);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test08JugadorIntentaMoverseHaciaArribaDeLosLimetesDelMapaYSuPosicionNoSeModifica(){
        Jugador jugador = new Jugador();
        Posicion posJugador = new Posicion(10,10);
        jugador.setPosicion(posJugador);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        mapa.moverJugador(new DireccionArriba());
        Posicion posEsperada = new Posicion(10,10);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }
    @Test
    public void test09JugadorIntentaMoverseHaciaAbajoDeLosLimetesDelMapaYSuPosicionNoSeModifica(){
        Jugador jugador = new Jugador();
        Posicion posJugador = new Posicion(10,0);
        jugador.setPosicion(posJugador);
        Mapa mapa = new Mapa(10);
        mapa.añadirJugador(jugador);
        mapa.moverJugador(new DireccionAbajo());
        Posicion posEsperada = new Posicion(10,0);

        assertEquals(jugador.obtenerPosicion(),posEsperada);
    }


}
