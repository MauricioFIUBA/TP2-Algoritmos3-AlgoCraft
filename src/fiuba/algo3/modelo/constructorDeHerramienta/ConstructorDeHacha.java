package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;

public abstract class ConstructorDeHacha extends ConstructorDeHerramienta{

    protected void establecerConstruccionValida(Material material){
        this.formaDeConstruccion = new MesaDeTrabajo();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicion1FiloInferior = new Posicion(0,1);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionAgarre, material);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionFiloSuperior, material);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicion1FiloInferior, material);
        this.crearMangoDeLaHerramienta();
    }
}
