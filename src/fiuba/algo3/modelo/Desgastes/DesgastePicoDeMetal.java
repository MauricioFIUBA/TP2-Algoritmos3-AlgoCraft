package fiuba.algo3.modelo.Desgastes;

public class DesgastePicoDeMetal extends Desgaste {
    private int cantidadDeUsos;
    public DesgastePicoDeMetal(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
        this.cantidadDeUsos = 0;
    }
    public void usar(){
        //Excepcion
        cantidadDeUsos++;
    }
}
