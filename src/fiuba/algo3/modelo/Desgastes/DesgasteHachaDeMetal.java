package fiuba.algo3.modelo.Desgastes;

public class DesgasteHachaDeMetal extends Desgaste {
    public DesgasteHachaDeMetal(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= (this.fuerza/2);
    }
}
