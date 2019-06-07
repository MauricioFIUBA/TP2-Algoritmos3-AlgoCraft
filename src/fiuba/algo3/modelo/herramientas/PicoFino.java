package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.desgastes.DesgastePicoFino;

public class PicoFino extends Pico {
    private Material filo;
    private Material punta;

    public PicoFino(){
        this.filo = new Piedra();
        this.tipoDeMateriales.add(this.filo);
        this.punta = new Metal();
        this.tipoDeMateriales.add(this.punta);
        this.tipoDeDesgaste = new DesgastePicoFino(1000,20);
    }
}
