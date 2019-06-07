package fiuba.algo3.modelo.jugador;

import fiuba.algo3.modelo.herramientas.*;
import fiuba.algo3.modelo.materiales.*;

public class Jugador {
    private Herramienta herramientaEquipada;
    public Jugador() {
        herramientaEquipada = new Hacha(new Madera());
    }
    public Herramienta showHerramientaEquipada() {
        return herramientaEquipada;
    }
}
