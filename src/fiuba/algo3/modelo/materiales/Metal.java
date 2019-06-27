package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Metal extends Material {

    public Metal(){
        durabilidad = 50;
    }

    @Override
    public void esDesgastadoPor(Herramienta herramienta) {
        herramienta.reconocerHerramienta(this);
    }

    //Chequeo de desgaste por herramienta

    public void esDesgastadoPor (Hacha unHacha) {
        unHacha.usar(this);
    }

    public void esDesgastadoPor (Pico unPico) {
        unPico.usar(this);
        Material unMaterial = unPico.getMaterial();
        this.desgastarsePorMaterial(unPico, unMaterial);
    }

    //Chequeo de desgaste por material de la herramienta

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Material unMaterial) {
        //Bloque de metal contra una herramienta de algun material
        unMaterial.desgastarsePorMaterial(unaHerramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Madera unaMadera) {
        //Herramienta de metal contra un bloque de madera
        unaMadera.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Piedra unaPiedra) {
        //Herramienta de metal contra un bloque de piedra
        unaPiedra.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Metal unMetal) {
        //Herramienta de metal contra un bloque de metal
        unMetal.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Diamante unDiamante) {
        //Herramienta de metal contra un bloque de diamante
        //diamante.durabilidad -= herramienta.getFuerza(); // ESto en Minecraft es posible, pero no en el TP
    }

    @Override
    public boolean igualQue(Material material){
        return material instanceof Metal;
    }
}
