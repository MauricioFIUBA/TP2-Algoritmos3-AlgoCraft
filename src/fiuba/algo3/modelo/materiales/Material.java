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
    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Material material);

    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Madera madera);

    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Piedra piedra);

    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Metal metal);

    protected abstract void desgastarsePorMaterial(Herramienta herramienta, Diamante diamante);
}