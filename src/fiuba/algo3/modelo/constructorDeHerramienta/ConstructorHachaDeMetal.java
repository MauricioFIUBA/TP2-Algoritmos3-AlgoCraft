package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Hacha;
import fiuba.algo3.modelo.materiales.Metal;

public class ConstructorHachaDeMetal extends ConstructorDeHacha {

    public ConstructorHachaDeMetal(){
        Metal metal = new Metal();
        this.herramientaACrear = new Hacha(metal);
        establecerConstruccionValida(metal);
    }
}