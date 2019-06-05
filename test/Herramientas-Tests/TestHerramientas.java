import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
public class TestHerramientas {
    @Test
    public void test01SeInstanciaUnHachaDeMadera() {
        Herramienta hachaDeMadera = new HachaDeMadera();
        assertNotNull(hachaDeMadera);
    }

    @Test
    public void test02SeCreaUnHachaDeMaderaConSuDurabilidadYFuerzaCorrespondiente() {
        Herramienta hachaDeMadera = new HachaDeMadera();
        assertEquals(hachaDeMadera.getDurabilidad(), 100);
        assertEquals(hachaDeMadera.getFuerza(), 2);
    }
    @Test
    public void test03SeInstanciaUnPicoDeMadera(){
        Herramienta picoDeMadera = new PicoDeMadera();
        assertNotNull(picoDeMadera);
    }
    @Test
    public void test04SeCreaUnPicoDeMaderaConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoDeMadera = new PicoDeMadera();
        assertEquals(picoDeMadera.getDurabilidad(),100);
        assertEquals(picoDeMadera.getFuerza(),2);
    }
    @Test
    public void test05SeInstanciaUnHachaDeMetal(){
        Herramienta hachaDeMetal = new HachaDeMetal();
        assertNotNull(hachaDeMetal);
    }
    @Test
    public void test06SeCreaUnHachaDeMetalConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta hachaDeMetal = new HachaDeMetal();
        assertEquals(hachaDeMetal.getDurabilidad(),400);
        assertEquals(hachaDeMetal.getFuerza(),10);
    }
    @Test
    public void test07SeInstanciaUnPicoDeMetal(){
        Herramienta picoDeMetal = new PicoDeMetal();
        assertNotNull(picoDeMetal);
    }
    @Test
    public void test08SeCreaUnPicoDeMetalConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoDeMetal = new PicoDeMetal();
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
