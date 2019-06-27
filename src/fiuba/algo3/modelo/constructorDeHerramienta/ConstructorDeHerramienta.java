package fiuba.algo3.modelo.constructorDeHerramienta;


import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;

public abstract class ConstructorDeHerramienta {

    protected MesaDeTrabajo formaDeConstruccion;
    protected Herramienta herramientaACrear;

    private boolean puedeConstruirCon(MesaDeTrabajo mesaDeTrabajoActual){
        return this.formaDeConstruccion.esIgualA(mesaDeTrabajoActual);
    }


    protected void crearMangoDeLaHerramienta(){
        Posicion posicionSuperiorDelMango = new Posicion(1,1);
        Posicion posicionInferiorDelMango = new Posicion(1,2);
        Madera madera = new Madera();

        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionSuperiorDelMango,madera);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionInferiorDelMango,madera);
    }

    public Herramienta construirHerramienta(MesaDeTrabajo mesaDeTrabajoActual){
        if(this.puedeConstruirCon(mesaDeTrabajoActual)) {
            return this.herramientaACrear;
        }
        return null;
    }

}
