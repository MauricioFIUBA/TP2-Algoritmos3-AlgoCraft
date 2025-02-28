package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;

public abstract class ConstructorDePico extends ConstructorDeHerramienta {

    protected void establecerConstruccionValida(Material material){
        this.formaDeConstruccion = new MesaDeTrabajo();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicion1FiloDerecho = new Posicion(2,0);
        this.crearMangoDeLaHerramienta();
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionAgarre, material);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicionFiloIzquierdo, material);
        this.formaDeConstruccion.agregarALaPosicionElMaterial(posicion1FiloDerecho, material);
    }
}
