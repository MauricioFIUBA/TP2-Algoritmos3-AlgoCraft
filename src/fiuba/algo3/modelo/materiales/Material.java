package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.herramientas.*;

public abstract class Material extends ElementoDelJuego {
    protected Integer durabilidad;

    public static Material forName(Madera madera) {
        return new Madera();
    }
    public static Material forName(Metal metal){
        return new Metal();
    }
    public static Material forName(Diamante diamante){
        return new Diamante();
    }
    public static Material forName(Piedra piedra){
        return new Piedra();
    }

    public Integer duracion() {
        return durabilidad;
    }

    /*public void desgastarse(Herramienta herramienta){
        herramienta.usar();
        //Material materialDeLaHerramienta = herramienta.getMaterial();
        //this.desgastarsePorMaterial(herramienta, materialDeLaHerramienta);
    }*/
    //Doble dispatch

    //Si el desgaste del material depende de cual es el tipo de material de la herramienta
    //que se usa, entonce se llama a este metodo
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Material material);


    //Estos metodos se llaman con el tipo de material de la herramienta

    //La herramienta esta desgastando una bloque de madera
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Madera madera);

    //La herramienta esta desgastando una bloque de piedra
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra);

    //La herramienta esta desgastando una bloque de metal
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Metal metal);

    //La herramienta esta desgastando una bloque de diamante
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante);
}