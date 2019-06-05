package Desgastes;

import Desgastes.Desgaste;

public class DesgasteHachaDeMetal extends Desgaste {
    public DesgasteHachaDeMetal(int unaDurabilidad, int unaFuerza){
        this.durabilidad = unaDurabilidad;
        this.fuerza = unaFuerza;
    }
    public void usar(){
        this.durabilidad -= (this.fuerza/2);
    }
}
