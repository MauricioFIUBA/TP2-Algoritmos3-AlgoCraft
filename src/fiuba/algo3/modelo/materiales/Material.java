package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public abstract class Material {
    protected Integer durabilidad;
    public Integer duracion() {
        return durabilidad;
    }

    /*public void desgastarse(Herramienta herramienta){
        herramienta.usar();
        //Material materialDeLaHerramienta = herramienta.getMaterial();
        //this.desgastarsePorMaterial(herramienta, materialDeLaHerramienta);
    }*/
    public  void esDesgastadoPor (Hacha hacha) {
        hacha.usar();
        //El material no hace nada si no es Madera
    }
    public  void esDesgastadoPor (Pico pico) {
        pico.usar();
        //El material no hace nada si es Madera
    }
    public  void esDesgastadoPor (PicoFino PicoFino) {

    }
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