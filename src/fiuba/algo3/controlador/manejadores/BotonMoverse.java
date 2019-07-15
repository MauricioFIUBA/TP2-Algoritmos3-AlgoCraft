package fiuba.algo3.controlador.manejadores;

import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.Mapa;

public class BotonMoverse {

    public void eventoMover(Direccion direccionActual, Mapa mapa){
        mapa.moverJugador(direccionActual);
    }

    public void eventoMoverALaIzquierda(Juego juego){
        this.eventoMover(new DireccionIzquierda(), juego.getMapa());
    }

    public void eventoMoverALaDerecha(Juego juego){
        this.eventoMover(new DireccionDerecha(), juego.getMapa());
    }

    public void eventoMoverArriba(Juego juego){
        this.eventoMover(new DireccionArriba(), juego.getMapa());
    }

    public void eventoMoverAbajo(Juego juego){
        this.eventoMover(new DireccionAbajo(), juego.getMapa());
    }
}
