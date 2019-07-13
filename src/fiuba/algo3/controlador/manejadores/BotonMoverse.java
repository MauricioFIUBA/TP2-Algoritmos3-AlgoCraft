package fiuba.algo3.controlador.manejadores;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.mapa.Mapa;

public class BotonMoverse {

    public void eventoMover(Direccion direccionActual, Mapa mapa){
        mapa.moverJugador(direccionActual);
    }

}
