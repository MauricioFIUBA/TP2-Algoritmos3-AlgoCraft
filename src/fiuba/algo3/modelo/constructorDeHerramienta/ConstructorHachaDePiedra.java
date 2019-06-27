package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.materiales.Piedra;

public class ConstructorHachaDePiedra extends ConstructorDeHacha {

    public ConstructorHachaDePiedra(){
        Piedra piedra = new Piedra();
        this.herramientaACrear = new Hacha(piedra);
        establecerConstruccionValida(piedra);
    }
}