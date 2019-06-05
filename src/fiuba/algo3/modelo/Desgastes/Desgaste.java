package fiuba.algo3.modelo.Desgastes;

public abstract class Desgaste{
    protected int durabilidad;
    protected int fuerza;
    public int getDurabilidad(){
        return this.durabilidad;
    }
    public int getFuerza(){
        return this.fuerza;
    }

    public abstract void usar();
}