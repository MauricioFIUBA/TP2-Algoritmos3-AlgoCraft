package fiuba.algo3.modelo.Herramientas;

import fiuba.algo3.modelo.Materiales.*;
import fiuba.algo3.modelo.Desgastes.DesgastePicoFino;

public class PicoFino extends Herramienta {
    private Material filo;
    private Material punta;

    public PicoFino(){
        this.filo = new Piedra();
        this.punta = new Metal();
        this.tipoDeDesgaste = new DesgastePicoFino(1000,20);
    }
}
