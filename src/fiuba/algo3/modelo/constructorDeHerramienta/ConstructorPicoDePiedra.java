package fiuba.algo3.modelo.constructorDeHerramienta;

import fiuba.algo3.modelo.herramientas.Pico;
import fiuba.algo3.modelo.materiales.Piedra;

public class ConstructorPicoDePiedra extends ConstructorDePico{

    public ConstructorPicoDePiedra(){
        Piedra piedra = new Piedra();
        this.herramientaACrear = new Pico(piedra);
        establecerConstruccionValida(piedra);
    }
}
