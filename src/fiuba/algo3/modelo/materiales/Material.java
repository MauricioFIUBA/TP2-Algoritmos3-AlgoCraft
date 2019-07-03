package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.herramientas.*;
import fiuba.algo3.modelo.jugador.Item;

public abstract class Material extends ElementoDelJuego implements Item{

    protected Integer durabilidad;

    public Integer duracion() {
        return durabilidad;
    }

    //Este metodo se llama cuando no se sabe que tipo de herramienta se llama
    public abstract void esDesgastadoPor(Herramienta unaHerramienta);

    public abstract void esDesgastadoPor(Hacha unHacha);

    public abstract void esDesgastadoPor(Pico unPico);
    //Doble dispatch

    //Si el desgaste del material depende de cual es el tipo de material de la herramienta
    //que se usa, entonce se llama a este metodo
    protected abstract void desgastarsePorMaterial(Herramienta unaHerramienta, Material unMaterial);

    //Estos metodos se llaman con el tipo de material de la herramienta

    //La herramienta esta desgastando una bloque de madera
    protected abstract void desgastarsePorMaterial(Herramienta unaHerramienta, Madera unaMadera);

    //La herramienta esta desgastando una bloque de piedra
    protected abstract void desgastarsePorMaterial(Herramienta unaHerramienta, Piedra unaPiedra);

    //La herramienta esta desgastando una bloque de metal
    protected abstract void desgastarsePorMaterial(Herramienta unaHerramienta, Metal unMetal);

    //La herramienta esta desgastando una bloque de diamante
    protected abstract void desgastarsePorMaterial(Herramienta unaHerramienta, Diamante unDiamante);

    public abstract boolean igualQue(Material material);
    public boolean roto(){
        return this.durabilidad==0;
    }
}