package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstructorDeHachaTest {

    @Test
    public void test01SeCreaUnConstructorDeHachaDeMadera() {
        ConstructorHachaDeMadera constructorHachaDeMadera = new ConstructorHachaDeMadera();
        assertNotEquals(constructorHachaDeMadera,null);
    }

    @Test
    public void test02SeCreaUnConstructorDeHachaDeMetal() {
        ConstructorHachaDeMetal constructorHachaDeMetal = new ConstructorHachaDeMetal();
        assertNotEquals(constructorHachaDeMetal,null);
    }

    @Test
    public void test03SeCreaUnConstructorDeHachaDePiedra() {
        ConstructorHachaDePiedra constructorHachaDePiedra = new ConstructorHachaDePiedra();
        assertNotEquals(constructorHachaDePiedra,null);
    }

    @Test
    public void test04SeCreaUnHachaDeMaderaATravezDeUnConstructorHachaDeMadera(){
        ConstructorHachaDeMadera constructorHachaDeMadera = new ConstructorHachaDeMadera();

        MesaDeTrabajo formaDeHachaDeMadera = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionAgarre,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionFiloSuperior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionFiloInferior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorHachaDeMadera.construirHerramienta(formaDeHachaDeMadera), null);
    }

    @Test
    public void test05SeCreaUnHachaDePiedraATravezDeUnConstructorHachaDePiedra(){
        ConstructorHachaDePiedra constructorHachaDePiedra = new ConstructorHachaDePiedra();

        MesaDeTrabajo formaDeHachaDePiedra = new MesaDeTrabajo();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionAgarre,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionFiloSuperior,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionFiloInferior,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionMangoInferior,madera);

        assertNotEquals(constructorHachaDePiedra.construirHerramienta(formaDeHachaDePiedra), null);
    }

    @Test
    public void test06SeCreaUnHachaDeMetalATravezDeUnConstructorHachaDeMetal(){
        ConstructorHachaDeMetal constructorHachaDeMetal = new ConstructorHachaDeMetal();

        MesaDeTrabajo formaDeHachaDeMetal = new MesaDeTrabajo();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionFiloSuperior,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionFiloInferior,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        Herramienta hachaDeMetal = constructorHachaDeMetal.construirHerramienta(formaDeHachaDeMetal);
        System.out.println(hachaDeMetal);
        System.out.println(hachaDeMetal.getMaterial());
        assertNotEquals(hachaDeMetal, null);
    }

    @Test
    public void test07SeIntentaCrearUnHachaDeMaderaATravezDeUnConstructorHachaDeMaderaConUnaConstruccionInvalida(){
        ConstructorHachaDeMadera constructorHachaDeMadera = new ConstructorHachaDeMadera();

        MesaDeTrabajo formaDeHachaDeMadera = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionAgarre,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionFiloSuperior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionFiloInferior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDeHachaDeMadera.agregarALaPosicionElMaterial(posicionInvalida,madera);


        assertEquals(constructorHachaDeMadera.construirHerramienta(formaDeHachaDeMadera), null);
    }

    @Test
    public void test08SeIntentaCrearUnHachaDePiedraATravezDeUnConstructorHachaDePiedraConUnaConstruccionInvalida(){
        ConstructorHachaDePiedra constructorHachaDePiedra = new ConstructorHachaDePiedra();

        MesaDeTrabajo formaDeHachaDePiedra = new MesaDeTrabajo();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionAgarre,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionFiloSuperior,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionFiloInferior,piedra);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDeHachaDePiedra.agregarALaPosicionElMaterial(posicionInvalida,piedra);

        assertEquals(constructorHachaDePiedra.construirHerramienta(formaDeHachaDePiedra), null);
    }

    @Test
    public void test09SeIntentaCrearUnHachaDeMetalATravezDeUnConstructorHachaDeMetalConUnaConstruccionInvalida(){
        ConstructorHachaDeMetal constructorHachaDeMetal = new ConstructorHachaDeMetal();

        MesaDeTrabajo formaDeHachaDeMetal = new MesaDeTrabajo();
        Metal metal = new Metal();
        Madera madera = new Madera();
        Posicion posicionAgarre = new Posicion(1,0);
        Posicion posicionFiloSuperior = new Posicion(0,0);
        Posicion posicionFiloInferior = new Posicion(0,1);
        Posicion posicionMangoSuperior = new Posicion(1,1);
        Posicion posicionMangoInferior = new Posicion(1,2);
        Posicion posicionInvalida = new Posicion(0,2);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionAgarre,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionFiloSuperior,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionFiloInferior,metal);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionMangoSuperior,madera);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionMangoInferior,madera);
        formaDeHachaDeMetal.agregarALaPosicionElMaterial(posicionInvalida,metal);


        assertEquals(constructorHachaDeMetal.construirHerramienta(formaDeHachaDeMetal), null);
    }

}
