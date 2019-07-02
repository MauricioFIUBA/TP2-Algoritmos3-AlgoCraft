package fiuba.algo3.modelo.constructorDeHerramienta;


import fiuba.algo3.modelo.herramientas.PicoFino;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;


public class ConstructorPicoFino extends ConstructorDeHerramienta{

    public ConstructorPicoFino(){
        formaDeConstruccion = new MesaDeTrabajo();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperiorIzquierdo = new Posicion(0,0);
        Posicion posicionFiloSuperiorDerecho = new Posicion(2,0);
        Posicion posicion1FiloInferiorIzquierdo = new Posicion(0,1);
        this.herramientaACrear = new PicoFino();
        this.crearMangoDeLaHerramienta();
        formaDeConstruccion.agregarALaPosicionElMaterial(posicionAgarre, metal);
        formaDeConstruccion.agregarALaPosicionElMaterial(posicionFiloSuperiorIzquierdo, metal);
        formaDeConstruccion.agregarALaPosicionElMaterial(posicionFiloSuperiorDerecho, metal);
        formaDeConstruccion.agregarALaPosicionElMaterial(posicion1FiloInferiorIzquierdo, piedra);
    }
}
