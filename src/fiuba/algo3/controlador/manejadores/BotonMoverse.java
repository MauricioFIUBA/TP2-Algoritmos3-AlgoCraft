package fiuba.algo3.controlador.manejadores;

import fiuba.algo3.modelo.direccion.Direccion;
import fiuba.algo3.modelo.mapa.Mapa;

public class BotonMoverse {

    public void eventoMover(Direccion direccionActual, Mapa mapa){
        //Posicion posicionVieja;
        //Posicion posicionNueva;
        //posicionVieja = mapa.obtenerPosicionDelJugador();
        mapa.moverJugador(direccionActual);
        //posicionNueva = mapa.obtenerPosicionDelJugador();
        //this.actualizarImagen(posicionVieja, posicionNueva);
    }

}
