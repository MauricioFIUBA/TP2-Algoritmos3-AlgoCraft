package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Diamante extends Material {
    public Diamante(){
        //Para que herramienta de diamante no setee dos veces la posicion y lance error.
        //Esto se podria corregir con hacer PicoDeDiamante.. HachaDeMadera etc??.
        durabilidad = 100;
    }

    public void esDesgastadoPor (PicoFino picoFino) {
        picoFino.usar(this);
        durabilidad -= picoFino.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Material material) {
        //Bloque de diamante contra una herramienta de algun material
        material.desgastarsePorMaterial(herramienta, this);
    }

    ////////En este trabajo practico no es posible crear herramientas de diamante//////
    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Madera madera) {
        //Herramienta de diamante contra un bloque de madera
        madera.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra) {
        //Herramienta de diamante contra bloque de piedra
        piedra.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Metal metal) {
        //Herramienta de diamante contra un bloque de metal
        metal.durabilidad -= herramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante) {
        //Herramienta de diamante contra un bloque de diamante
        diamante.durabilidad -= herramienta.getFuerza();
    }
}