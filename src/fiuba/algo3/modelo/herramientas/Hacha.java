package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.desgastes.DesgastePorMultiplo;
import fiuba.algo3.modelo.materiales.*;

public class Hacha extends Herramienta {
    public Hacha(Madera madera){
        this.tipoDeMateriales.add(madera);
        this.tipoDeDesgaste = new DesgastePorMultiplo(100,2,1);
    }
    public Hacha(Piedra piedra){
        this.tipoDeMateriales.add(piedra);
        this.tipoDeDesgaste = new DesgastePorMultiplo(200,5,1);
    }
    public Hacha(Metal metal){
        this.tipoDeMateriales.add(metal);
        this.tipoDeDesgaste = new DesgastePorMultiplo(400,10,1/2);
    }

    @Override
    public void reconocerHerramienta(Madera unaMadera) {
        unaMadera.esDesgastadoPor(this);
    }

    @Override
    public void reconocerHerramienta(Piedra unaPiedra) {
        unaPiedra.esDesgastadoPor(this);
    }

    @Override
    public void reconocerHerramienta(Metal unMetal) {
        unMetal.esDesgastadoPor(this);
    }

    @Override
    public void reconocerHerramienta(Diamante unaDiamante) {
        unaDiamante.esDesgastadoPor(this);
    }
}
