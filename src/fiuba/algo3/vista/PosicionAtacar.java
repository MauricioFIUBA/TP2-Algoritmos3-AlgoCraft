package fiuba.algo3.vista;

import fiuba.algo3.modelo.mapa.Posicion;

public class PosicionAtacar {
    boolean atacada;
    Posicion posicion;

    public PosicionAtacar(boolean fueAtacada, Posicion posicionAtacada) {
        atacada = fueAtacada;
        posicion = posicionAtacada;
    }

    public boolean fueAtacada() {
        return atacada;
    }

    public Posicion getPosicionAtacada() {
        return posicion;
    }
}

