package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.desgastes.DesgastePorDurabilidad;
import fiuba.algo3.modelo.materiales.*;

public class PicoFino extends Pico {
    private Material filo;
    private Material punta;
    /*Falta implementar que picofino solo se desgaste con el diamante.
    Y buscar una altternativa al constructor para que tenga dos tipos de materiales.*/
    public PicoFino(){
        this.filo = new Piedra();
        this.tipoDeMateriales.add(this.filo);
        this.punta = new Metal();
        this.tipoDeMateriales.add(this.punta);
        this.tipoDeDesgaste = new DesgastePorDurabilidad(1000,20,0.1);
    }
}
