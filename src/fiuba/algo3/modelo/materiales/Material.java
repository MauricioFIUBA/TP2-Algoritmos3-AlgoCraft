package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public abstract class Material {
    protected Integer durabilidad;
    public Integer duracion() {
        return durabilidad;
    }

    public  void desgastarse (Hacha hacha) {
        hacha.usar();
        //El material no hace nada si no es Madera
    }
    public  void desgastarse (Pico pico) {
        pico.usar();
        //El material no hace nada si es Madera
    }
//    public  void desgastarse (PicoFino PicoFino) {
//        Pico pico = new Pico(new Madera());
//        this.desgastarse(pico);
//    }
    protected void desgastarsePorMaterial(Herramienta herramienta, Madera madera) {
        System.out.println("entro?");
    }

    protected void desgastarsePorMaterial(Herramienta herramienta, Piedra material) {
        durabilidad -= herramienta.getFuerza();
    }

    protected void desgastarsePorMaterial(Herramienta herramienta, Metal material) {
        durabilidad -= herramienta.getFuerza();
    }

    protected void desgastarsePorMaterial(Herramienta herramienta, Diamante material) {
        durabilidad -= herramienta.getFuerza();
    }
}