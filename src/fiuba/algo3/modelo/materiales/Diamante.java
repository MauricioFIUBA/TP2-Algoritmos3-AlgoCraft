package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Diamante extends Material {
    public Diamante(){
        //Para que herramienta de diamante no setee dos veces la posicion y lance error.
        //Esto se podria corregir con hacer PicoDeDiamante.. HachaDeMadera etc??.
        durabilidad = 100;
    }

    @Override
    public void esDesgastadoPor(Herramienta unaHerramienta) {
        unaHerramienta.reconocerHerramienta(this);
    }

    //Chequeo de desgaste por herramienta

    public void esDesgastadoPor (Hacha unHacha) {
        unHacha.usar(this);
    }

    public void esDesgastadoPor (Pico unPico) {
        unPico.usar(this);
    }

    public void esDesgastadoPor (PicoFino unPicoFino) {
        unPicoFino.usar(this);
        this.durabilidad -= unPicoFino.getFuerza();
    }

    //Chequeo de desgaste por material de la herramienta

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Material unMaterial) {
        //Bloque de diamante contra una herramienta de algun material
        unMaterial.desgastarsePorMaterial(unaHerramienta, this);
    }

    ////////En este trabajo practico no es posible crear herramientas de diamante//////
    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Madera unaMadera) {
        //Herramienta de diamante contra un bloque de madera
        unaMadera.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Piedra unaPiedra) {
        //Herramienta de diamante contra bloque de piedra
        unaPiedra.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Metal unMetal) {
        //Herramienta de diamante contra un bloque de metal
        unMetal.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Diamante unDiamante) {
        //Herramienta de diamante contra un bloque de diamante
        unDiamante.durabilidad -= unaHerramienta.getFuerza();
    }
}