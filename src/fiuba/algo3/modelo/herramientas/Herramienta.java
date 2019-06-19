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

    public void usar(Diamante material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Madera material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Metal material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Piedra material){
        this.tipoDeDesgaste.usar();
    }
}
