package fiuba.algo3.controlador.manejadores;

import fiuba.algo3.modelo.direccion.DireccionAbajo;
import fiuba.algo3.modelo.direccion.DireccionArriba;
import fiuba.algo3.modelo.direccion.DireccionDerecha;
import fiuba.algo3.modelo.direccion.DireccionIzquierda;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.vista.PosicionAtacar;

public class BotonDesgastarMaterial {


    private boolean eventoDesgastarMaterial(Posicion posicionAtaque, Juego juego){
        boolean atacar = false;
        if(juego.getMapa().perteneceAlMapa(posicionAtaque)) {
            juego.atacarEn(posicionAtaque);
            atacar = true;
        }
        return atacar;
    }

    public PosicionAtacar eventoDesgastarMaterialArriba(Juego juego) {
        Posicion materialAtacado = juego.posicionDeAtaque(new DireccionArriba());
        boolean fueAtaca = this.eventoDesgastarMaterial(materialAtacado, juego);
        return new PosicionAtacar(fueAtaca, materialAtacado);
    }

    public PosicionAtacar eventoDesgastarMaterialALaIzquierda(Juego juego) {
        Posicion materialAtacado = juego.posicionDeAtaque(new DireccionIzquierda());
        boolean fueAtaca = this.eventoDesgastarMaterial(materialAtacado, juego);
        return new PosicionAtacar(fueAtaca, materialAtacado);
    }

    public PosicionAtacar eventoDesgastarMaterialAbajo(Juego juego) {
        Posicion materialAtacado = juego.posicionDeAtaque(new DireccionAbajo());
        boolean fueAtaca = this.eventoDesgastarMaterial(materialAtacado, juego);
        return new PosicionAtacar(fueAtaca, materialAtacado);
    }

    public PosicionAtacar eventoDesgastarMaterialALaDerecha(Juego juego) {
        Posicion materialAtacado = juego.posicionDeAtaque(new DireccionDerecha());
        boolean fueAtaca = this.eventoDesgastarMaterial(materialAtacado, juego);
        return new PosicionAtacar(fueAtaca, materialAtacado);
    }
}
