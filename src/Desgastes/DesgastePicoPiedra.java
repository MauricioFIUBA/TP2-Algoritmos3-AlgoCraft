package Desgastes;

//import Desgastes.;

public class DesgastePicoPiedra extends Desgaste{
    public DesgastePicoPiedra(int unaDurabilidad, int unaFuerza) {
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= (this.fuerza)/1.5;
    }
}
