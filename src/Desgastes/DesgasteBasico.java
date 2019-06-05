package Desgastes;

import Desgastes.Desgaste;

public class DesgasteBasico extends Desgaste {
    public DesgasteBasico(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= this.fuerza;
    }
}
