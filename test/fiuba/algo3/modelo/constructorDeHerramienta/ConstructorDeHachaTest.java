package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;




public class ConstructorDeHachaTest {

    @Test
    public void test01SeCreaUnConstructorDeHachaDeMadera() {
        ConstructorHachaDeMadera constructorHachaDeMadera = new ConstructorHachaDeMadera();
        assertNotNull(constructorHachaDeMadera);
    }

    @Test
    public void test02SeCreaUnConstructorDeHachaDeMetal() {
        ConstructorHachaDeMetal constructorHachaDeMetal = new ConstructorHachaDeMetal();
        assertNotNull(constructorHachaDeMetal);
    }

    @Test
    public void test03SeCreaUnConstructorDeHachaDePiedra() {
        ConstructorHachaDePiedra constructorHachaDePiedra = new ConstructorHachaDePiedra();
        assertNotNull(constructorHachaDePiedra);
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

        Herramienta hachaDeMadera = constructorHachaDeMadera.construirHerramienta(formaDeHachaDeMadera);
        assertNotNull(hachaDeMadera);
        assertThat(hachaDeMadera, instanceOf(Hacha.class));
        assertThat(hachaDeMadera.getMaterial(), instanceOf(Madera.class));
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

        Herramienta hachaDePiedra = constructorHachaDePiedra.construirHerramienta(formaDeHachaDePiedra);
        assertNotNull(hachaDePiedra);
        assertThat(hachaDePiedra, instanceOf(Hacha.class));
        assertThat(hachaDePiedra.getMaterial(), instanceOf(Piedra.class));
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
        assertNotNull(hachaDeMetal);
        assertThat(hachaDeMetal, instanceOf(Hacha.class));
        assertThat(hachaDeMetal.getMaterial(), instanceOf(Metal.class));
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

        Herramienta hachaDeMadera = constructorHachaDeMadera.construirHerramienta(formaDeHachaDeMadera);
        assertNull(hachaDeMadera);
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

        Herramienta hachaDePiedra = constructorHachaDePiedra.construirHerramienta(formaDeHachaDePiedra);
        assertNull(hachaDePiedra);
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

        Herramienta hachaDeMetal = constructorHachaDeMetal.construirHerramienta(formaDeHachaDeMetal);
        assertNull(hachaDeMetal);
    }



}
