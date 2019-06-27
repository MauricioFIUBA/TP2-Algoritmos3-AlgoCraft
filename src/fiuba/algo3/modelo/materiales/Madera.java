package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Madera extends Material {

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public void esDesgastadoPor(Herramienta unaHerramienta) {
        unaHerramienta.reconocerHerramienta(this);
    }

    //Chequeo de desgaste por herramienta

    @Override
    public void esDesgastadoPor(Hacha unHacha) {
        unHacha.usar(this);
        Material unMaterial = unHacha.getMaterial();
        this.desgastarsePorMaterial(unHacha, unMaterial);
    }

    @Override
    public void esDesgastadoPor(Pico unPico) {
        unPico.usar(this);
    }

    //Chequeo de desgaste por material de la herramienta

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Material unMaterial) {
        //Bloque de madera contra una herramienta de un material
        unMaterial.desgastarsePorMaterial(unaHerramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Madera unaMadera) {
        //Herramienta de madera contra un bloque de madera
        unaMadera.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Piedra unaPiedra) {
        //Herramienta de madera contra un bloque de piedra
        unaPiedra.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Metal unMetal) {
        //Herramienta de madera contra un bloque de metal
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Diamante unDiamante) {
        //Herramienta de madera contra un bloque de diamante
    }

    @Override
    public boolean igualQue(Material material){
        return material instanceof Madera;
    }

}