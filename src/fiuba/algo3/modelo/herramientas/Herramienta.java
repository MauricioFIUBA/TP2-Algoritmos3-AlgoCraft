package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.desgastes.Desgaste;
import fiuba.algo3.modelo.jugador.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Herramienta implements Item{
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

    //Estos metodos sirven para que se el material sepa de que tipo es la herramienta que se esta usando
    //y asi saber si tiene que desgastarse o no
    public abstract void reconocerHerramienta(Madera unaMadera);
    public abstract void reconocerHerramienta(Piedra unaPiedra);
    public abstract void reconocerHerramienta(Metal unMetal);
    public abstract void reconocerHerramienta(Diamante unaDiamante);

    public void usar(Diamante unDiamante){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Madera unaMadera){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Metal unMetal){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Piedra unaPiedra){
        this.tipoDeDesgaste.usar();
    }

    public boolean estaRota() {
        return this.tipoDeDesgaste.getDurabilidad() <= 0;
    }

    @Override
    public boolean esUnaHerramienta() {
        return true;
    }
}
