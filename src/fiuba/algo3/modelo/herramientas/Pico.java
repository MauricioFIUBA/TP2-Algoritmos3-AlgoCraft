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
