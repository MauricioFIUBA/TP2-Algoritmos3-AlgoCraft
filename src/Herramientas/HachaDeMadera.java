import Desgastes.DesgasteBasico;
import Materiales.Madera;

public class HachaDeMadera extends Herramienta {
    public void inicializarDesgaste() {
        this.tipoDeMaterial = new Madera();
        this.tipoDeDesgaste = new DesgasteBasico(100,2);
    }
}
