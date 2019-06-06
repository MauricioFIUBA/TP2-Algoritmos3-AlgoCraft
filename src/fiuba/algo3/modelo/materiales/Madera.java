package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Madera extends Material {
    public Madera() {
        durabilidad = 10;
    }

    public void desgastarse(Hacha hacha) {
        hacha.usar();
        durabilidad -= hacha.getFuerza();
    }

}