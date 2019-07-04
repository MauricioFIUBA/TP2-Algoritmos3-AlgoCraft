package fiuba.algo3.modelo.jugador;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.materiales.Madera;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends ElementoDelJuego {
    private Herramienta herramientaEquipada;
    List<Item> inventario = new ArrayList<Item>();
    public Jugador() {
        herramientaEquipada = new Hacha(new Madera());
        inventario.add(herramientaEquipada);
    }

    public int cantidadItems() { return inventario.size(); }
    public List<Item> getItems(){return inventario;}

    public Herramienta getHerramientaEquipada(){
        return this.herramientaEquipada;
    }

    public void añadirItem(Item itemNuevo){ inventario.add(itemNuevo);}


    public void equiparHerramienta(Herramienta unaHerramienta) {
        herramientaEquipada = unaHerramienta;
        inventario.add(unaHerramienta);
    }

    public boolean herramientaEquipadaRota() {
        return herramientaEquipada.getDurabilidad()<=0;
    }

    public void eliminarHerramientaEquipada(){
        inventario.remove(herramientaEquipada);
        herramientaEquipada = null;
    }

}
