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
        this.cambiarSiguienteHerramienta();
    }

    public void cambiarSiguienteHerramienta() {
        int posArmaActual = inventario.indexOf(herramientaEquipada) + 1;
        System.out.println(posArmaActual);
        boolean armaSiguieteExiste = false;
        boolean armaAnteriorExiste = false;
        int posArmaAnterior = 0;
        while (posArmaAnterior < posArmaActual && !armaAnteriorExiste) {
            if (inventario.get(posArmaAnterior).esUnaHerramienta()) {
                armaAnteriorExiste = true;
            }
        }
        while ( posArmaActual < inventario.size() && !armaSiguieteExiste ){
            if (inventario.get(posArmaActual).esUnaHerramienta()){
                System.out.println("entro");
                this.herramientaEquipada = (Herramienta) inventario.get(posArmaActual);
                armaSiguieteExiste = true;
            }
            posArmaActual++;
        }
        if(!armaSiguieteExiste) {
            if(armaAnteriorExiste) {
                this.herramientaEquipada = (Herramienta) inventario.get(posArmaAnterior);
            } else {
                this.herramientaEquipada = null;
            }
        }
//        if(!armaSiguieteExiste) {
//            System.out.println("entro");
//            i = 0;
//            while (i < inventario.size() && !armaSiguieteExiste) {
//                if (inventario.get(i).esUnaHerramienta()) {
//                    this.herramientaEquipada = (Herramienta) inventario.get(i);
//                    armaSiguieteExiste = true;
//                }
//
//            }
//        }
    }


    @Override
    public boolean esMaterial() {
        return false;
    }
}
