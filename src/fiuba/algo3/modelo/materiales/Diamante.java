package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Diamante extends Material {
    public Diamante() {
        durabilidad = 100;
    }

    public void desgastarse (PicoFino picoFino) {
        picoFino.usar();
        durabilidad -= picoFino.getFuerza();
    }
}