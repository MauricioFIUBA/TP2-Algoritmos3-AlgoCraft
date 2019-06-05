package fiuba.algo3.modelo.Desgastes;

public class DesgasteBasico extends Desgaste {
    public DesgasteBasico(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= this.fuerza;
    }
}
