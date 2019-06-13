package fiuba.algo3.modelo.desgastes;

public class DesgastePorMultiplo extends Desgaste {
    private double multiplo;
    public DesgastePorMultiplo(int unaDurabilidad, int unaFuerza, double unMultiplo){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
        this.multiplo = unMultiplo;
    }
    public void usar(){
        this.durabilidad -= ((this.fuerza) * (this.multiplo));
    }
}
