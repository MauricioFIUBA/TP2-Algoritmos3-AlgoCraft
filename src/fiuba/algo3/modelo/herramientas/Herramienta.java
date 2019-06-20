package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.desgastes.Desgaste;

import java.util.ArrayList;
import java.util.List;

public abstract class Herramienta{
    protected List<Material> tipoDeMateriales = new ArrayList<Material>();
    protected Desgaste tipoDeDesgaste;

    public int getDurabilidad(){
        return this.tipoDeDesgaste.getDurabilidad();
    }

    public int getFuerza(){
        return this.tipoDeDesgaste.getFuerza();
    }

    public Material getMaterial() {
        return this.tipoDeMateriales.get(0);
    }

    public abstract void reconocerHerramienta(Material unMaterial);

    public abstract void usar(Diamante unDiamante);/*{
        this.tipoDeDesgaste.usar();
    }*/
    public abstract void usar(Madera unaMadera);/*{
        this.tipoDeDesgaste.usar();
    }*/
    public abstract void usar(Metal unMetal);/*{
        this.tipoDeDesgaste.usar();
    }*/
    public abstract void usar(Piedra unaPiedra);/*{
        this.tipoDeDesgaste.usar();
    }*/
}
