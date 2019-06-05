package Desgastes;

import Desgastes.Desgaste;

public class DesgastePicoFino extends Desgaste {
    public DesgastePicoFino(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= (this.durabilidad * 0.1);
    }
}
