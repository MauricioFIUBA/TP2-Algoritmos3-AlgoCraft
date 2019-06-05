package fiuba.algo3.modelo.Herramientas;

import fiuba.algo3.modelo.Materiales.*;
import fiuba.algo3.modelo.Desgastes.DesgasteBasico;
import fiuba.algo3.modelo.Desgastes.DesgasteHachaDeMetal;

public class Hacha extends Herramienta {
    public Hacha(Madera madera){
        this.tipoDeMaterial = madera;
        this.tipoDeDesgaste = new DesgasteBasico(100,2);
    }
    public Hacha(Piedra piedra){
        this.tipoDeMaterial = piedra;
        this.tipoDeDesgaste = new DesgasteBasico(200,5);
    }
    public Hacha(Metal metal){
        this.tipoDeMaterial = metal;
        this.tipoDeDesgaste = new DesgasteHachaDeMetal(400,10);
    }
}
