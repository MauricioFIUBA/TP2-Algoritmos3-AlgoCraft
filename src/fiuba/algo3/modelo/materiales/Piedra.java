package fiuba.algo3.modelo.materiales;


import fiuba.algo3.modelo.herramientas.*;

public class Piedra extends Material {
    public Piedra() {
        durabilidad = 30;
    }

    public void desgastarse (Pico pico) {
        pico.usar();
        durabilidad -= pico.getFuerza();
    }
}
