package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Pico;
import fiuba.algo3.modelo.materiales.Metal;

public class ConstructorPicoDeMetal extends ConstructorDePico{

    public ConstructorPicoDeMetal(){
        Metal metal = new Metal();
        this.herramientaACrear = new Pico(metal);
        establecerConstruccionValida(metal);
    }

}

