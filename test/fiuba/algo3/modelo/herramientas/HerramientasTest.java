package fiuba.algo3.modelo.herramientas;
import fiuba.algo3.modelo.materiales.*;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
public class HerramientasTest {
    @Test
    public void test01SeInstanciaUnHachaDeMadera() {
        Herramienta hachaDeMadera = new Hacha(new Madera());
        assertNotNull(hachaDeMadera);
    }

    @Test
    public void test02SeCreaUnHachaDeMaderaConSuDurabilidadYFuerzaCorrespondiente() {
        Herramienta hachaDeMadera = new Hacha(new Madera());
        assertEquals(hachaDeMadera.getDurabilidad(), 100);
        assertEquals(hachaDeMadera.getFuerza(), 2);
    }
    @Test
    public void test03SeInstanciaUnPicoDeMadera(){
        Herramienta picoDeMadera = new Pico(new Madera());
        assertNotNull(picoDeMadera);
    }
    @Test
    public void test04SeCreaUnPicoDeMaderaConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoDeMadera = new Pico(new Madera());
        assertEquals(picoDeMadera.getDurabilidad(),100);
        assertEquals(picoDeMadera.getFuerza(),2);
    }
    @Test
    public void test05SeInstanciaUnHachaDeMetal(){
        Herramienta hachaDeMetal = new Hacha(new Metal());
        assertNotNull(hachaDeMetal);
    }
    @Test
    public void test06SeCreaUnHachaDeMetalConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta hachaDeMetal = new Hacha(new Metal());
        assertEquals(hachaDeMetal.getDurabilidad(),400);
        assertEquals(hachaDeMetal.getFuerza(),10);
    }
    @Test
    public void test07SeInstanciaUnPicoDeMetal(){
        Herramienta picoDeMetal = new Pico(new Metal());
        assertNotNull(picoDeMetal);
    }
    @Test
    public void test08SeCreaUnPicoDeMetalConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoDeMetal = new Pico(new Metal());
        assertEquals(picoDeMetal.getDurabilidad(),400);
        assertEquals(picoDeMetal.getFuerza(),12);
    }
    @Test
    public void test09SeInstanciaUnPicoFino(){
        Herramienta picoFino = new PicoFino();
        assertNotNull(picoFino);
    }
    @Test
    public void test10SeCreaUnPicoFinoConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoFino = new PicoFino();
        assertEquals(picoFino.getDurabilidad(),1000);
        assertEquals(picoFino.getFuerza(),20);
    }
}
