package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstructorPicoFinoTest {

    @Test
    public void test01SeCreaUnConstructorDePicoDeMadera() {
        ConstructorPicoDeMadera constructorPicoDeMadera = new ConstructorPicoDeMadera();
        assertNotEquals(constructorPicoDeMadera,null);
    }

    @Test
    public void test02SeCreaUnPicoFinoATravezDeUnConstructorPicoFino(){
        ConstructorPicoFino constructorPicoFino = new ConstructorPicoFino();

        MesaDeTrabajo formaDePicoFino = new MesaDeTrabajo();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperiorIzquierdo = new Posicion(0,0);
        Posicion posicionFiloSuperiorDerecho = new Posicion(2,0);
        Posicion posicionFiloInferiorIzquierdo = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloSuperiorIzquierdo,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloSuperiorDerecho,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloInferiorIzquierdo,piedra);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorPicoFino.construirHerramienta(formaDePicoFino), null);
    }


    @Test
    public void test03SeIntentaCrearUnPicoFinoATravezDeUnConstructorPicoFinoConUnaConstruccionInvalida(){
        ConstructorPicoFino constructorPicoFino = new ConstructorPicoFino();

        MesaDeTrabajo formaDePicoFino = new MesaDeTrabajo();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperiorIzquierdo = new Posicion(0,0);
        Posicion posicionFiloSuperiorDerecho = new Posicion(2,0);
        Posicion posicionFiloInferiorIzquierdo = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloSuperiorIzquierdo,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloSuperiorDerecho,metal);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionFiloInferiorIzquierdo,piedra);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDePicoFino.agregarALaPosicionElMaterial(posicionInvalida,metal);

        assertEquals(constructorPicoFino.construirHerramienta(formaDePicoFino), null);
    }

}

