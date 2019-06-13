package fiuba.algo3.modelo.desgastes;

public class DesgastePorUsos extends Desgaste {
    private int cantidadDeUsos;
    public DesgastePorUsos(int unaDurabilidad, int unaFuerza){
        this.cantidadDeUsos = 0;
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.cantidadDeUsos++;
    }
}
