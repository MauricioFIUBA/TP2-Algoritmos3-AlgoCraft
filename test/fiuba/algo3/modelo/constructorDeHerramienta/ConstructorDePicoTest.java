package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.herramientas.Pico;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import fiuba.algo3.modelo.mesaDeTrabajo.MesaDeTrabajo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorDePicoTest {

    @Test
    public void test01SeCreaUnConstructorDePicoDeMadera() {
        ConstructorPicoDeMadera constructorPicoDeMadera = new ConstructorPicoDeMadera();
        assertNotNull(constructorPicoDeMadera);
    }

    @Test
    public void test02SeCreaUnConstructorDePicoDeMetal() {
        ConstructorPicoDeMetal constructorPicoDeMetal = new ConstructorPicoDeMetal();
        assertNotNull(constructorPicoDeMetal);
    }

    @Test
    public void test03SeCreaUnConstructorDePicoDePiedra() {
        ConstructorPicoDePiedra constructorPicoDePiedra = new ConstructorPicoDePiedra();
        assertNotNull(constructorPicoDePiedra);
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

        Herramienta picoDeMadera = constructorPicoDeMadera.construirHerramienta(formaDePicoDeMadera);
        assertNotNull(picoDeMadera);
        assertThat(picoDeMadera, instanceOf(Pico.class));
        assertThat(picoDeMadera.getMaterial(), instanceOf(Madera.class));
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

        Herramienta picoDePiedra = constructorPicoDePiedra.construirHerramienta(formaDePicoDePiedra);
        assertNotNull(picoDePiedra);
        assertThat(picoDePiedra, instanceOf(Pico.class));
        assertThat(picoDePiedra.getMaterial(), instanceOf(Piedra.class));
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

        Herramienta picoDeMetal = constructorPicoDeMetal.construirHerramienta(formaDePicoDeMetal);
        assertNotNull(picoDeMetal);
        assertThat(picoDeMetal, instanceOf(Pico.class));
        assertThat(picoDeMetal.getMaterial(), instanceOf(Metal.class));
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

        Herramienta picoDeMadera = constructorPicoDeMadera.construirHerramienta(formaDePicoDeMadera);
        assertNull(picoDeMadera);
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

        Herramienta picoDePiedra = constructorPicoDePiedra.construirHerramienta(formaDePicoDePiedra);
        assertNull(picoDePiedra);
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

        Herramienta picoDeMetal = constructorPicoDeMetal.construirHerramienta(formaDePicoDeMetal);
        assertNull(picoDeMetal);
    }

}
