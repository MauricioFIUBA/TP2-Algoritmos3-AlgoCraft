package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Madera extends Material {
    public Madera() {
        durabilidad = 10;
    }

    @Override
    public void esDesgastadoPor(Hacha hacha) {
        hacha.usar(this);
        durabilidad -= hacha.getFuerza();
    }
    //double dispatch


    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Material material) {
        //Bloque de madera contra una herramienta de un material
        material.desgastarsePorMaterial(herramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Madera madera) {
        //Herramienta de madera contra un bloque de madera
        this.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra) {
        //Herramienta de madera contra un bloque de piedra
        this.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Metal metal) {
        //Herramienta de madera contra un bloque de metal
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante) {
        //Herramienta de madera contra un bloque de diamante
    }

}