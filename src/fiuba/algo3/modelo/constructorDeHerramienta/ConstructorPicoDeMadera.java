package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Pico;
import fiuba.algo3.modelo.materiales.Madera;

public class ConstructorPicoDeMadera extends ConstructorDePico{

    public ConstructorPicoDeMadera(){
        Madera madera = new Madera();
        this.herramientaACrear = new Pico(madera);
        establecerConstruccionValida(madera);
    }

}
