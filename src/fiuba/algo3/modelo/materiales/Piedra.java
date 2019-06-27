package fiuba.algo3.modelo.materiales;


import fiuba.algo3.modelo.herramientas.*;

public class Piedra extends Material {
    public Piedra(){
        durabilidad =  30;
    }
    @Override
    public void esDesgastadoPor(Herramienta unaHerramienta) {
        unaHerramienta.reconocerHerramienta(this);
    }

    //Chequeo de desgaste por herramienta

    @Override
    public void esDesgastadoPor (Hacha unHacha) {
        unHacha.usar(this);
    }

    @Override
    public void esDesgastadoPor (Pico unPico) {
        unPico.usar(this);
        Material unMaterial = unPico.getMaterial();
        this.desgastarsePorMaterial(unPico, unMaterial);
    }

    //Chequeo de desgaste por material de la herramienta

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Material unMaterial) {
        //Bloque de piedra contra una herramienta de algun material
        unMaterial.desgastarsePorMaterial(unaHerramienta, this);
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Madera unaMadera) {
        //Herramienta de piedra contra un bloque de madera
        unaMadera.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Piedra unaPiedra) {
        //Herramienta de piedra contra un bloque de piedra
        unaPiedra.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Metal unMetal) {
        //Herramienta de piedra contra un bloque de metal
        unMetal.durabilidad -= unaHerramienta.getFuerza();
    }

    @Override
    protected void desgastarsePorMaterial(Herramienta unaHerramienta, Diamante unDiamante) {
        //Herramienta de piedra contra un bloque de diamante
    }

    @Override
    public boolean igualQue(Material material){
        if(material instanceof Piedra){
            return true;
        }
        return false;
    }
}
