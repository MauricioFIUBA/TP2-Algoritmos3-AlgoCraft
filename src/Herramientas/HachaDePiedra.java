import Desgastes.DesgasteBasico;

public class HachaDePiedra extends Herramienta {

    @Override
    public void inicializarDesgaste() {
        this.tipoDeDesgaste = new DesgasteBasico(200,5);
    }
}
