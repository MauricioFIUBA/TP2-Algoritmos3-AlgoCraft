package fiuba.algo3.modelo.materiales;


import fiuba.algo3.modelo.herramientas.*;

public class Piedra extends Material {
    public Piedra() {
        durabilidad = 30;
    }

    @Override
    public void esDesgastadoPor (Pico pico) {
        pico.usar();
        durabilidad -= pico.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Material material) {
        //Bloque de piedra contra una herramienta de algun material
        material.desgastarsePorMaterial(herramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Madera madera) {
        //Herramienta de piedra contra un bloque de madera
        durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra) {
        //Herramienta de piedra contra un bloque de piedra
        durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Metal metal) {
        //Herramienta de piedra contra un bloque de metal
        metal.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante) {
        //Herramienta de piedra contra un bloque de diamante
    }
}
