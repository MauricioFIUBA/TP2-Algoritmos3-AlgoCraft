package fiuba.algo3.modelo.herramientas;
import fiuba.algo3.modelo.materiales.*;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void test03SeCreaUnHachaDeMaderaYSeLaUsaContraUnBloqueDeMaderaYBajaLaDurabilidadDelHacha(){
        Hacha hachaDeMadera = new Hacha(new Madera());
        Madera madera = new Madera();
        int durabilidadHacha = hachaDeMadera.getDurabilidad();
        madera.esDesgastadoPor(hachaDeMadera);
        assertEquals(hachaDeMadera.getDurabilidad(), durabilidadHacha- (hachaDeMadera.getFuerza()));
    }
    @Test
    public void test04SeCreaUnHachaDeMaderaYSeLaUsaContraUnBloqueDePiedraYBajaLaDurabilidadDelHacha(){
        Hacha hachaDeMadera = new Hacha(new Madera());
        Piedra piedra = new Piedra();
        int durabilidadHacha = hachaDeMadera.getDurabilidad();
        piedra.esDesgastadoPor(hachaDeMadera);
        assertEquals(hachaDeMadera.getDurabilidad(), durabilidadHacha- (hachaDeMadera.getFuerza()));
    }
    @Test
    public void test05SeCreaUnHachaDeMaderaYSeLaUsaContraUnBloqueDeMetalYBajaLaDurabilidadDelHacha(){
        Hacha hachaDeMadera = new Hacha(new Madera());
        Metal metal = new Metal();
        int durabilidadHacha = hachaDeMadera.getDurabilidad();
        metal.esDesgastadoPor(hachaDeMadera);
        assertEquals(hachaDeMadera.getDurabilidad(), durabilidadHacha- (hachaDeMadera.getFuerza()));
    }
    @Test
    public void test06SeCreaUnHachaDeMaderaYSeLaUsaContraUnBloqueDeDiamanteYBajaLaDurabilidadDelHacha(){
        Hacha hachaDeMadera = new Hacha(new Madera());
        Diamante diamante = new Diamante();
        int durabilidadHacha = hachaDeMadera.getDurabilidad();
        diamante.esDesgastadoPor(hachaDeMadera);
        assertEquals(hachaDeMadera.getDurabilidad(), durabilidadHacha- (hachaDeMadera.getFuerza()));
    }

    @Test
    public void test07SeInstanciaUnPicoDeMadera(){
        Herramienta picoDeMadera = new Pico(new Madera());
        assertNotNull(picoDeMadera);
    }
    @Test
    public void test08SeCreaUnPicoDeMaderaConSuDurabilidadYFuerzaCorrespondiente(){
        Herramienta picoDeMadera = new Pico(new Madera());
        assertEquals(picoDeMadera.getDurabilidad(),100);
        assertEquals(picoDeMadera.getFuerza(),2);
    }
    @Test
    public void test09SeCreaUnPicoDeMaderaYSeLoUsaContraUnBloqueDeMaderaYElPicoDeMaderaBajaSuDurabilidad(){
        Pico picoDeMadera = new Pico(new Madera());
        Madera madera = new Madera();
        int durabilidadPicoDeMadera = picoDeMadera.getDurabilidad();
        madera.esDesgastadoPor(picoDeMadera);
        assertEquals(picoDeMadera.getDurabilidad(), durabilidadPicoDeMadera - (picoDeMadera.getFuerza()));
    }
    @Test
    public void test10SeCreaUnPicoDeMaderaYSeLoUsaContraUnBloqueDePiedraYElPicoDeMaderaBajaSuDurabilidad(){
        Pico picoDeMadera = new Pico(new Madera());
        Piedra piedra = new Piedra();
        int durabilidadPicoDeMadera = picoDeMadera.getDurabilidad();
        piedra.esDesgastadoPor(picoDeMadera);
        assertEquals(picoDeMadera.getDurabilidad(), durabilidadPicoDeMadera - (picoDeMadera.getFuerza()));
    }
    @Test
    public void test11SeCreaUnPicoDeMaderaYSeLoUsaContraUnBloqueDeMetalYElPicoDeMaderaBajaSuDurabilidad(){
        Pico picoDeMadera = new Pico(new Madera());
        Metal metal = new Metal();
        int durabilidadPicoDeMadera = picoDeMadera.getDurabilidad();
        metal.esDesgastadoPor(picoDeMadera);
        assertEquals(picoDeMadera.getDurabilidad(), durabilidadPicoDeMadera - (picoDeMadera.getFuerza()));
    }
    @Test
    public void test12SeCreaUnPicoDeMaderaYSeLoUsaContraUnBloqueDeDiamanteYElPicoDeMaderaBajaSuDurabilidad(){
        Pico picoDeMadera = new Pico(new Madera());
        Diamante diamante = new Diamante();
        int durabilidadPicoDeMadera = picoDeMadera.getDurabilidad();
        diamante.esDesgastadoPor(picoDeMadera);
        assertEquals(picoDeMadera.getDurabilidad(), durabilidadPicoDeMadera - (picoDeMadera.getFuerza()));
    }
    @Test
    public void test09SeInstanciaUnHachaDeMetal(){
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
    @Test
    public void test11SeCreaUnPicoFinoYSeLoUsaContraUnBloqueDeMaderaYElPicoFinoNoSeDesgasta(){
        PicoFino picoFino = new PicoFino();
        Madera madera = new Madera();
        int esperado = picoFino.getDurabilidad();
        madera.esDesgastadoPor(picoFino);
        assertEquals(picoFino.getDurabilidad(),esperado);
    }
    @Test
    public void test12SeCreaUnPicoFinoYSeLoUsaContraUnBloqueDePiedraYElPicoFinoNoSeDesgasta(){
        PicoFino picoFino = new PicoFino();
        Piedra piedra = new Piedra();
        int esperado = picoFino.getDurabilidad();
        piedra.esDesgastadoPor(picoFino);
        assertEquals(picoFino.getDurabilidad(), esperado);
    }
    @Test
    public void test13SeCreaUnPicoFinoYSeLoUsaContraUnBloqueDeMetalYElPicoFinoNoSeDesgasta(){
        PicoFino picoFino = new PicoFino();
        Metal metal = new Metal();
        int esperado = picoFino.getDurabilidad();
        metal.esDesgastadoPor(picoFino);
        assertEquals(picoFino.getDurabilidad(), esperado);
    }
    @Test
    public void test14SeCreaUnPicoFinoYSeLoUsaContraUnBloqueDeDiamanteYElPicoFinoSeDesgasta(){
        PicoFino picoFino = new PicoFino();
        Diamante diamante = new Diamante();
        //Tuve que castear a int para que corra el test.
        int esperado = (int) (picoFino.getDurabilidad() - (picoFino.getDurabilidad()*0.1));
        diamante.esDesgastadoPor(picoFino);
        assertEquals(picoFino.getDurabilidad(),esperado);
    }

}
