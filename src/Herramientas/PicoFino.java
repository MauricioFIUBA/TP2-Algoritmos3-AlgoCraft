import Desgastes.DesgastePicoFino;
import Materiales.Material;
import Materiales.Metal;
import Materiales.Piedra;

public class PicoFino extends Herramienta {
    private Material filo;
    private Material punta;

    @Override
    public void inicializarDesgaste(){
        this.filo = new Piedra();
        this.punta = new Metal();
        this.tipoDeDesgaste = new DesgastePicoFino(1000,20);
    }
}
