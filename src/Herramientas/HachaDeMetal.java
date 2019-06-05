import Desgastes.DesgasteHachaDeMetal;

public class HachaDeMetal extends Herramienta {
    @Override
    public void inicializarDesgaste() {
        this.tipoDeDesgaste = new DesgasteHachaDeMetal(400,10);
    }
}
