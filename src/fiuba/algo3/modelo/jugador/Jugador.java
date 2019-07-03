package fiuba.algo3.modelo.jugador;

import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.herramientas.*;
import fiuba.algo3.modelo.materiales.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends ElementoDelJuego {
    private Herramienta herramientaEquipada;
    List<Item> inventario = new ArrayList<Item>();
    public Jugador() {
        herramientaEquipada = new Hacha(new Madera());
        inventario.add(herramientaEquipada);
    }
    public Herramienta showHerramientaEquipada() {
        return herramientaEquipada;
    }

    public int cantidadItems() { return inventario.size(); }
    public List<Item> getItems(){return inventario;}
}
