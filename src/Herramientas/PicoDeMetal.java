import Desgastes.DesgastePicoDeMetal;
import Materiales.Metal;

public class PicoDeMetal extends Herramienta{
    public void inicializarDesgaste(){
        this.tipoDeMaterial = new Metal();
        this.tipoDeDesgaste = new DesgastePicoDeMetal(400,12);
    }
}
