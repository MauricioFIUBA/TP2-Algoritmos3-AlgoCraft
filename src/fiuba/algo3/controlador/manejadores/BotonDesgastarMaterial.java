package fiuba.algo3.controlador.manejadores;

import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;

public class BotonDesgastarMaterial {


    public boolean eventoDesgastarMaterial(Posicion posicionAtaque, Mapa mapa){
        boolean atacar = false;
        if(mapa.perteneceAlMapa(posicionAtaque)) {
            mapa.atacarEn(posicionAtaque);
            atacar = true;
        }
        return atacar;
    }
}
