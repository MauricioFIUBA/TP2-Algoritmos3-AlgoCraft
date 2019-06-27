package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstructorDePicoTest {

    @Test
    public void test01SeCreaUnConstructorDePicoDeMadera() {
        ConstructorPicoDeMadera constructorPicoDeMadera = new ConstructorPicoDeMadera();
        assertNotEquals(constructorPicoDeMadera,null);
    }

    @Test
    public void test02SeCreaUnConstructorDePicoDeMetal() {
        ConstructorPicoDeMetal constructorPicoDeMetal = new ConstructorPicoDeMetal();
        assertNotEquals(constructorPicoDeMetal,null);
    }

    @Test
    public void test03SeCreaUnConstructorDePicoDePiedra() {
        ConstructorPicoDePiedra constructorPicoDePiedra = new ConstructorPicoDePiedra();
        assertNotEquals(constructorPicoDePiedra,null);
    }

    @Test
    public void test04SeCreaUnPicoDeMaderaATravezDeUnConstructorPicoDeMadera(){
        ConstructorPicoDeMadera constructorPicoDeMadera = new ConstructorPicoDeMadera();

        MesaDeTrabajo formaDePicoDeMadera = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionAgarre,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionFiloIzquierdo,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionFiloDerecho,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorPicoDeMadera.construirHerramienta(formaDePicoDeMadera), null);
    }

    @Test
    public void test05SeCreaUnPicoDePiedraATravezDeUnConstructorPicoDePiedra(){
        ConstructorPicoDePiedra constructorPicoDePiedra = new ConstructorPicoDePiedra();

        MesaDeTrabajo formaDePicoDePiedra = new MesaDeTrabajo();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionAgarre,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionFiloIzquierdo,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionFiloDerecho,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorPicoDePiedra.construirHerramienta(formaDePicoDePiedra), null);
    }

    @Test
    public void test06SeCreaUnPicoDeMetalATravezDeUnConstructorPicoDeMetal(){
        ConstructorPicoDeMetal constructorPicoDeMetal = new ConstructorPicoDeMetal();

        MesaDeTrabajo formaDePicoDeMetal = new MesaDeTrabajo();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionFiloIzquierdo,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionFiloDerecho,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorPicoDeMetal.construirHerramienta(formaDePicoDeMetal), null);
    }

    @Test
    public void test07SeIntentaCrearUnPicoDeMaderaATravezDeUnConstructorPicoDeMaderaConUnaConstruccionInvalida(){
        ConstructorPicoDeMadera constructorPicoDeMadera = new ConstructorPicoDeMadera();

        MesaDeTrabajo formaDePicoDeMadera = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionAgarre,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionFiloIzquierdo,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionFiloDerecho,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDePicoDeMadera.agregarALaPosicionElMaterial(posicionInvalida,madera);


        assertEquals(constructorPicoDeMadera.construirHerramienta(formaDePicoDeMadera), null);
    }

    @Test
    public void test08SeIntentaCrearUnPicoDePiedraATravezDeUnConstructorPicoDePiedraConUnaConstruccionInvalida(){
        ConstructorPicoDePiedra constructorPicoDePiedra = new ConstructorPicoDePiedra();

        MesaDeTrabajo formaDePicoDePiedra = new MesaDeTrabajo();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionAgarre,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionFiloIzquierdo,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionFiloDerecho,piedra);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDePicoDePiedra.agregarALaPosicionElMaterial(posicionInvalida,piedra);

        assertEquals(constructorPicoDePiedra.construirHerramienta(formaDePicoDePiedra), null);
    }

    @Test
    public void test09SeIntentaCrearUnPicoDeMetalATravezDeUnConstructorPicoDeMetalConUnaConstruccionInvalida(){
        ConstructorPicoDeMetal constructorPicoDeMetal = new ConstructorPicoDeMetal();

        MesaDeTrabajo formaDePicoDeMetal = new MesaDeTrabajo();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloIzquierdo = new Posicion(0,0);
        Posicion posicionFiloDerecho = new Posicion(2,0);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionFiloIzquierdo,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionFiloDerecho,metal);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDePicoDeMetal.agregarALaPosicionElMaterial(posicionInvalida,metal);


        assertEquals(constructorPicoDeMetal.construirHerramienta(formaDePicoDeMetal), null);
    }

}
