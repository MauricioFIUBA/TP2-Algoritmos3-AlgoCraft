package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.materiales.Piedra;

public class ConstructorHachaDePiedra extends ConstructorDeHacha {

    public ConstructorHachaDePiedra(){
        Piedra piedra = new Piedra();
        herramientaACrear = new Hacha(piedra);
        establecerConstruccionValida(piedra);
    }
}