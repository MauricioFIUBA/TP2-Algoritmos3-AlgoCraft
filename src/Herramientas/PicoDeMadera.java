import Desgastes.DesgasteBasico;
import Materiales.Madera;

public class PicoDeMadera extends Herramienta {
    public void inicializarDesgaste(){
        this.tipoDeMaterial = new Madera();
        this.tipoDeDesgaste = new DesgasteBasico(100,2);
    }


}
