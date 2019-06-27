package fiuba.algo3.modelo.mesaDeTrabajo;


import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Material;

import java.util.HashMap;
import java.util.Map;

public class MesaDeTrabajo {
    private Integer capacidadMaxima;
    private Map<Posicion, Material> tableroDeConstruccion;
    private Integer maximaPosicion;


    public MesaDeTrabajo(){
        this.tableroDeConstruccion = new HashMap<Posicion, Material>();
        this.capacidadMaxima = Math.abs(3) * Math.abs(3);
        this.maximaPosicion = Math.abs(3);
    }

    public Integer obtenerCapacidadDelTablero(){
        return this.capacidadMaxima;
    }

    public boolean perteneceAlTablero(Posicion posicionActual){
        return this.tableroDeConstruccion.containsKey(posicionActual);
    }

    public void agregarALaPosicionElMaterial(Posicion posicionActual, Material materialActual){
        if((this.capacidadMaxima!=0) && (posicionActual.estaDentroDeLos(this.maximaPosicion)) && (!perteneceAlTablero(posicionActual))) {
            this.tableroDeConstruccion.put(posicionActual, materialActual);
            this.capacidadMaxima--;
        }
    }

    public void eliminarMaterialDeLaPosicion(Posicion posicionActual){
        this.tableroDeConstruccion.remove(posicionActual);
        this.capacidadMaxima++;
    }

    public Map<Posicion, Material> getTableroDeConstruccion(){
        return tableroDeConstruccion;
    }

    public boolean esIgualA(MesaDeTrabajo mesaDeTrabajoActual){
        boolean iguales = true;
        for(Map.Entry<Posicion,Material> entry1 : mesaDeTrabajoActual.getTableroDeConstruccion().entrySet()) {
            Posicion posicionActual = entry1.getKey();
            if ((!tableroDeConstruccion.containsKey(posicionActual)) || (!tableroDeConstruccion.get(posicionActual).igualQue(entry1.getValue()))) {
                iguales = false;
            }
        }
        return iguales;
    }

}