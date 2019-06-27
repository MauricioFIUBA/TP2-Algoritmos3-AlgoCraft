package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.materiales.Madera;

public class ConstructorHachaDeMadera extends ConstructorDeHacha {

    public ConstructorHachaDeMadera(){
        Madera madera = new Madera();
        herramientaACrear = new Hacha(madera);
        establecerConstruccionValida(madera);
    }
}
