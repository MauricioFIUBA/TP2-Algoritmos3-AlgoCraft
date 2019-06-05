package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.desgastes.DesgasteBasico;
import fiuba.algo3.modelo.desgastes.DesgastePicoDeMetal;
import fiuba.algo3.modelo.desgastes.DesgastePicoPiedra;

public class Pico extends Herramienta {
    public Pico(Madera madera){
        this.tipoDeMaterial = madera;
        this.tipoDeDesgaste = new DesgasteBasico(100,2);
    }
    public Pico(Piedra piedra){
        this.tipoDeMaterial = piedra;
        this.tipoDeDesgaste = new DesgastePicoPiedra(200,4);
    }
    public Pico(Metal metal){
        this.tipoDeMaterial = metal;
        this.tipoDeDesgaste = new DesgastePicoDeMetal(400,12);
    }
}
