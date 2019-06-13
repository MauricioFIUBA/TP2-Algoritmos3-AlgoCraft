package fiuba.algo3.modelo.desgastes;

public class DesgastePorDurabilidad extends Desgaste {
    private double multiplo;
    public DesgastePorDurabilidad(int unaDurabilidad, int unaFuerza, double unMultiplo){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
        this.multiplo = unMultiplo;
    }
    public void usar(){
        this.durabilidad -= ((this.durabilidad) * (this.multiplo));
    }
}
