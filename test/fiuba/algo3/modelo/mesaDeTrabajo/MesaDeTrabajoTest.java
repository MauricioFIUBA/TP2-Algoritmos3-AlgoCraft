package fiuba.algo3.modelo.mesaDeTrabajo;

import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MesaDeTrabajoTest {

    @Test
    public void test01SeCreaUnaMesaDeTrabajo() {
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();

        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(), 9);
    }

    @Test
    public void test02SeAgregaUnMaterialEnUnaPosicionValida(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);

        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(), 8);

    }

    @Test
    public void test03SeAgregaUnMaterialEnUnaPosicionInvalida(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(2,4);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);

        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(), 9);
    }

    @Test
    public void test04SeVerificaQueNoSePuedeOcuparUnCasilleroYaOcupadoDeLaMesaDeTrabajo(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);
        Metal metal = new Metal();
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion,metal);

        assertTrue(mesaDeTrabajo.perteneceAlTablero(posicion));
        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(), 8);

    }

    @Test
    public void test05SeAgregaUnMaterialEnUnaPosicionValidaYSeLoElimina(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);

        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(), 8);

        mesaDeTrabajo.eliminarMaterialDeLaPosicion(posicion);

        assertEquals(mesaDeTrabajo.obtenerCapacidadDelTablero(),9);

    }

    @Test
    public void test06SeVerificanQueDosMesasDeTrabajoTienenElMismoMaterialEnLaMismaPosicion(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);

        MesaDeTrabajo mesaDeTrabajoActual = new MesaDeTrabajo();
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(posicion, madera);

        assertTrue(mesaDeTrabajo.esIgualA(mesaDeTrabajoActual));
    }

    @Test
    public void test07SeVerificanQueDosMesasDeTrabajoTienenDistintosMaterialesEnLasMismasPosiciones(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicion = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicion, madera);

        MesaDeTrabajo mesaDeTrabajoActual = new MesaDeTrabajo();
        Metal metal = new Metal();
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(posicion, metal);

        assertFalse(mesaDeTrabajo.esIgualA(mesaDeTrabajoActual));
    }

    @Test
    public void test08SeVerificanQueDosMesasDeTrabajoTienenDistintosMaterialessEnDistintaPosicion(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion posicionMadera = new Posicion(1,1);
        mesaDeTrabajo.agregarALaPosicionElMaterial(posicionMadera, madera);

        MesaDeTrabajo mesaDeTrabajoActual = new MesaDeTrabajo();
        Metal metal = new Metal();
        Posicion posicionMetal = new Posicion(2,2);
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(posicionMadera, madera);
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(posicionMetal, metal);

        assertFalse(mesaDeTrabajo.esIgualA(mesaDeTrabajoActual));
    }

    @Test
    public void test09SeVerificanQueDosMesasDeTrabajoTienenLosMismosMaterialesEnLasMismasPosiciones(){
        MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajo();
        Madera madera = new Madera();
        Posicion primeraPosicion = new Posicion(1,1);
        Posicion segundaPosicion = new Posicion(1,2);
        mesaDeTrabajo.agregarALaPosicionElMaterial(primeraPosicion, madera);
        mesaDeTrabajo.agregarALaPosicionElMaterial(segundaPosicion, madera);


        MesaDeTrabajo mesaDeTrabajoActual = new MesaDeTrabajo();
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(primeraPosicion, madera);
        mesaDeTrabajoActual.agregarALaPosicionElMaterial(segundaPosicion, madera);


        assertTrue(mesaDeTrabajo.esIgualA(mesaDeTrabajoActual));
    }
}
