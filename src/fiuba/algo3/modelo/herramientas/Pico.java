package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.desgastes.*;
import fiuba.algo3.modelo.materiales.*;

public class Pico extends Herramienta {
    public Pico(){}
    public Pico(Madera madera){
        this.tipoDeMateriales.add(madera);
        this.tipoDeDesgaste = new DesgastePorMultiplo(100,2,1);
    }
    public Pico(Piedra piedra){
        this.tipoDeMateriales.add(piedra);
        this.tipoDeDesgaste = new DesgastePorMultiplo(200,4,2/3);
    }
    public Pico(Metal metal) {
        this.tipoDeMateriales.add(metal);
        this.tipoDeDesgaste = new DesgastePorUsos(400, 12);
    }

    @Override
    public void reconocerHerramienta(Material unMaterial) {
        unMaterial.esDesgastadoPor(this);
    }

    @Override
    public void usar(Madera unaMadera) {
        this.tipoDeDesgaste.usar();

    }

    @Override
    public void usar(Piedra unaPiedra) {
        this.tipoDeDesgaste.usar();
    }

    @Override
    public void usar(Metal unMetal) {
        this.tipoDeDesgaste.usar();
    }

    @Override
    public void usar(Diamante unDiamante) {
        this.tipoDeDesgaste.usar();
    }
}
