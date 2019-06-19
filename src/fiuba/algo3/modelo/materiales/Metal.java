package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Metal extends Material {
    public Metal() {
        durabilidad = 50;
    }

    public void esDesgastadoPor (Pico pico) {
        pico.usar(this);
        Material material = pico.getMaterial();
        this.desgastarsePorMaterial(pico, material);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Material material) {
        //Bloque de metal contra una herramienta de algun material
        material.desgastarsePorMaterial(herramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Madera madera) {
        //Herramienta de metal contra un bloque de madera
        madera.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra) {
        //Herramienta de metal contra un bloque de piedra
        piedra.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Metal metal) {
        //Herramienta de metal contra un bloque de metal
        metal.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante) {
        //Herramienta de metal contra un bloque de diamante
        //diamante.durabilidad -= herramienta.getFuerza(); // ESto en Minecraft es posible, pero no en el TP
    }
}
